package com.moilioncircle.r056;

import jssc.SerialPortException;

/**
 * @author trydofor
 * @since 2017-10-26
 */
public interface CaptureCallback<T> {

    /**
     * 获得一个重量读数
     */
    void capture(final T s);

    /**
     * 读取时发生错误
     */
    void error(final String e);
}
