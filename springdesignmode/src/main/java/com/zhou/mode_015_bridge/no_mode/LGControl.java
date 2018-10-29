/**
 * Date:     2018/10/2923:05
 * AUTHOR:   Administrator
 */
package com.zhou.mode_015_bridge.no_mode;

/**
 * 2018/10/29  23:05
 * created by zhoumb
 */
public class LGControl implements Control {
    @Override
    public void on() {
        System.out.println("open LG tv");
    }

    @Override
    public void off() {
        System.out.println("off LG tv");
    }

    @Override
    public void setChannel(int ch) {
        System.out.println("the LG TV Channel is setted " + ch + "*");
    }

    @Override
    public void setVolume(int vol) {
        System.out.println("LG tv set volume " + vol + "*");
    }
}
