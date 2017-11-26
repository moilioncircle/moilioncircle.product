package com.moilioncircle.r056.serialport;

import jssc.SerialPort;

/**
 * @author trydofor
 * @since 2017-10-31
 */
public enum PortType {
    R1200_8_1_X(SerialPort.BAUDRATE_1200,
            SerialPort.DATABITS_8,
            SerialPort.STOPBITS_1,
            SerialPort.PARITY_NONE);

    private final int baudRate;
    private final int dataBits;
    private final int stopBits;
    private final int parity;

    PortType(int baudRate, int dataBits, int stopBits, int parity) {
        this.baudRate = baudRate;
        this.dataBits = dataBits;
        this.stopBits = stopBits;
        this.parity = parity;
    }

    public int getBaudRate() {
        return baudRate;
    }

    public int getDataBits() {
        return dataBits;
    }

    public int getStopBits() {
        return stopBits;
    }

    public int getParity() {
        return parity;
    }
}
