package com.moilioncircle.r056.camera;

import com.moilioncircle.r056.CaptureCallback;
import com.moilioncircle.r056.ConnectCallback;
import com.sun.jna.Pointer;

import java.awt.image.BufferedImage;

/**
 * @author trydofor
 * @since 2017-10-20
 */
public class CameraSdk {

    private static Pointer cameraPointer = null;
    private static Pointer offlinePointer = null;
    private static boolean isInitedLib = false;
    private static boolean isSnapMode = true;
    private static boolean isSnapStarted = false;

    private static int frameRate = 2;
    private static int payLoadSize = -1;
    private static int imageWidth = -1;
    private static int imageHeight = -1;
    private static int pixelColorFilter = -1;

    private CameraSdk() {
    }

    /**
     * 打开第一个摄像头，如果有多个，自己hack一下代码，目前没这需求。
     */
    public static synchronized void open() {
        close();


        setSnapMode(true);
        listen((ConnectCallback) null); // 注册空的掉线事件
    }

    /**
     * 监听拍照完成事件。必须先 #open()
     */
    public static synchronized void listen(final CaptureCallback<BufferedImage> callback) {
    }

    /**
     * 监听掉线事件。必须先 #open()
     */
    public static synchronized void listen(final ConnectCallback callback) {
    }

    /**
     * 设置采集模式，默认触发模式，否则为连续采集(每秒14帧)
     *
     * @param t 是否为触发模式，默认触发模式。
     */
    public static synchronized void setSnapMode(boolean t) {
    }

    /**
     * 拍一张照片，使用CaptureCallBack 接收图片
     */
    public static synchronized void snap() {
    }

    /**
     * 设置每秒采集多少张，主要是连续采集时影响较大，默认2
     *
     * @param rate 每秒几张
     */
    public static synchronized void frame(int rate) {
    }

    /**
     * 关闭连接和设备
     */
    public static synchronized void close() {

    }

    /**
     * 设备上是否打开
     *
     * @return true标识打开
     */
    public static boolean isOpen() {
        return cameraPointer != null;
    }

    /**
     * 设备上是否连接
     *
     * @return true标识连接
     */
    public static boolean isConn() {
        return isOpen(); // 因为掉线后自动close，两者等同
    }

    /**
     * 查看当前是否为触发模式
     */
    public static boolean isSnapMode() {
        return isSnapMode;
    }

    /**
     * 图片宽度
     */
    public static int getImageWidth() {
        return imageWidth;
    }

    /**
     * 图片高度
     */
    public static int getImageHeight() {
        return imageHeight;
    }

    /**
     * 当前帧频
     */
    public static int getFrameRate() {
        return frameRate;
    }
}
