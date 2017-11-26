package com.moilioncircle.r056;

/**
 * @author trydofor
 * @since 2017-11-06
 */
public interface ConnectCallback {
    /**
     * 掉线后连线时触发
     */
    void online();

    /**
     * 连线时掉线触发（超时没有读数）
     */
    void offline();
}
