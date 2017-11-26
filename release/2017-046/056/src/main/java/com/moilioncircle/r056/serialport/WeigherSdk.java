package com.moilioncircle.r056.serialport;

import com.moilioncircle.r056.CaptureCallback;
import com.moilioncircle.r056.ConnectCallback;
import jssc.*;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author trydofor
 * @since 2017-10-26
 */
public class WeigherSdk {

    private static final long offlineTime = 2 * 1000;
    private static String portName = "COM1";
    private static SerialPort serialPort = null;

    private static ConnectCallback connectCallback;
    private static CaptureCallback<String> weigherCallback;

    private static volatile boolean isOpen = false;
    private static volatile boolean isConn = false;
    private static volatile boolean isSnapMode = true;

    private static final AtomicInteger snapping = new AtomicInteger(0);


    private WeigherSdk() {
    }

    /**
     * 返回可用的串口，如果没有返回空数组。
     */
    public static String[] list() {
        return SerialPortList.getPortNames();
    }

    /**
     * 监听称重读数
     *
     * @param callback callback
     */
    public static synchronized void listen(CaptureCallback<String> callback) {
        weigherCallback = callback;
    }

    /**
     * 监听连接状态
     *
     * @param callback callback
     */
    public static synchronized void listen(ConnectCallback callback) {
        connectCallback = callback;
    }


    /**
     * 打开一个串口，1200 比特率，8bit，1停止，无校验，如果需要别的，自己hack
     *
     * @param name 串口名字
     * @throws SerialPortException 连接异常
     */
    public static synchronized void open(final String name, final PortType type) throws SerialPortException {

        close();

        final SerialPort port = new SerialPort(name);
        port.openPort();
        port.setParams(type.getBaudRate(),
                type.getDataBits(),
                type.getStopBits(),
                type.getParity());

        SerialPortEventListener listener = new SerialPortEventListener() {
            private StringBuilder sb = new StringBuilder(50);
            private boolean ready = false; // 第一个可能不完整，跳过，第二个开始为完整的。
            private volatile long lastRead = System.currentTimeMillis();
            private final AtomicInteger lineStatus = new AtomicInteger(-1); // -1:未初始化；0：掉线； 1：连线。

            class OffDemon extends Thread {
                @Override
                public void run() {
                    while (true) {
                        try {
                            sleep(offlineTime);
                            if (System.currentTimeMillis() - lastRead > offlineTime) {
                                lineStatus.set(0);
                                isConn = false;

                                if (isOpen) {
                                    connectCallbackInvoke(false);
                                }

                                break;
                            }
                        } catch (InterruptedException e) {
                            // ignore
                        }
                    }
                }
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                lastRead = System.currentTimeMillis();

                if (event.isRXCHAR() && event.getEventValue() > 0) {
                    final CaptureCallback<String> callback = weigherCallback;
                    try {
                        byte[] bytes = port.readBytes(); // read first

                        if (lineStatus.get() != 1) {
                            isConn = true;
                            ready = false;
                            synchronized (lineStatus) {
                                int io = lineStatus.get();
                                lineStatus.set(1);
                                if (io != 1) {
                                    lastRead = System.currentTimeMillis() + offlineTime * 3; // 等3个周期
                                    new OffDemon().start(); // 重新启动监听线程
                                    if (io == 0) { // 初始化不回调
                                        connectCallbackInvoke(true);
                                    }
                                }
                            }
                        }

                        // 如果触发模式，并且不是抓拍中
                        if (isSnapMode && snapping.get() <= 0) {
                            ready = false;
                            return;
                        }

                        for (int i = 0; i < bytes.length; i++) {
                            char c = (char) bytes[i];

                            if (c == '\r' || c == '\n') {
                                if (sb.length() == 0) continue;

                                String str = sb.toString();
                                sb.delete(0, str.length());
                                if (!ready) {
                                    ready = true;
                                } else {

                                    if(isSnapMode) {
                                        synchronized (snapping) { // 不为负数
                                            if (snapping.get() > 0) {
                                                snapping.decrementAndGet();
                                            }
                                        }
                                    }

                                    if (callback != null) {
                                        callback.capture(str);
                                    }
                                }
                            } else if (c > 31 && c < 127) { // 有效Ascii
                                sb.append(c);
                            }
                        }
                    } catch (SerialPortException ex) {
                        if (callback != null) {
                            callback.error(ex.toString());
                        }
                    }
                } else if (event.isCTS() || event.isDSR()) {//If CTS line has changed state
                    isConn = event.getEventValue() == 1;
                    connectCallbackInvoke(isConn);
                }
            }

            private void connectCallbackInvoke(boolean isConn) {
                final ConnectCallback callback = connectCallback;
                if (callback != null) {
                    if (isConn) {
                        callback.online();
                    } else {
                        callback.offline();
                    }
                }
            }
        };

        isSnapMode = true;
        isOpen = true;
        isConn = true;
        portName = name;
        serialPort = port;
        port.addEventListener(listener, SerialPort.MASK_RXCHAR | SerialPort.MASK_CTS | SerialPort.MASK_DSR);
    }

    /**
     * 读一个重量，使用 CaptureCallback 接收图片
     */
    public static void snap() {
        synchronized (snapping) {
            snapping.incrementAndGet();
        }
    }

    /**
     * 关闭一个串口
     *
     * @throws SerialPortException 连接异常
     */
    public static synchronized void close() throws SerialPortException {
        isOpen = false;
        isConn = false;

        if (serialPort != null) {
            if (serialPort.isOpened()) {
                serialPort.closePort();
            }
        }
    }

    /**
     * 设置采集模式，默认触发模式，否则为连续采集(每秒14帧)
     *
     * @param t 是否为触发模式，默认触发模式。
     */
    public static synchronized void setSnapMode(boolean t) {
        isSnapMode = t;
    }
    /**
     * 查看当前是否为触发模式
     */
    public static boolean isSnapMode() {
        return isSnapMode;
    }

    /**
     * 是否端口已打开，关闭即为打开
     *
     * @return true为 opens
     */
    public static boolean isOpen() {
        return isOpen;
    }

    /**
     * 是否端口已连接
     *
     * @return true 为连接中
     */
    public static boolean isConn() {
        return isConn;
    }

    /**
     * 获得打开的串口名
     *
     * @return 串口名
     */
    public static String getPortName() {
        return portName;
    }
}
