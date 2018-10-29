/**
 * Date:     2018/10/2923:03
 * AUTHOR:   Administrator
 */
package com.zhou.mode_015_bridge.no_mode;

/**
 * 2018/10/29  23:03
 * created by zhoumb
 */
public class SonyControl implements Control {
    @Override
    public void on() {
        System.out.println("open sony tv");
    }

    @Override
    public void off() {
        System.out.println("off sony tv");
    }

    @Override
    public void setChannel(int ch) {
        System.out.println("the sony TV Channel is setted " + ch + "*");
    }

    @Override
    public void setVolume(int vol) {
        System.out.println("sony tv set volume " + vol + "*");
    }
}
