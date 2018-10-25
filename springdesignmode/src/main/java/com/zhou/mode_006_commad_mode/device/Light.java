/**
 * Date:     2018/10/2521:27
 * AUTHOR:   Administrator
 */
package com.zhou.mode_006_commad_mode.device;

/**
 * 命令模式-设备-电灯
 * 2018/10/25  21:27
 * created by zhoumb
 */
public class Light {
    String loc = "";

    public Light(String loc) {
        this.loc = loc;
    }

    public void on() {
        System.out.println(loc + "on");
    }

    public void off() {
        System.out.println(loc + "off");
    }

}
