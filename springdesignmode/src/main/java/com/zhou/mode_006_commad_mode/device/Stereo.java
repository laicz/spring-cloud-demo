/**
 * Date:     2018/10/2521:32
 * AUTHOR:   Administrator
 */
package com.zhou.mode_006_commad_mode.device;

/**
 * 命令模式-设备-音响
 * 2018/10/25  21:32
 * created by zhoumb
 */
public class Stereo {

    static int volume = 0;

    public void on() {
        System.out.println("Stereo on");
    }

    public void off() {
        System.out.println("Stereo off");
    }

    public void setCd() {
        System.out.println("Stereo SetCd");
    }

    public void setVol(int vol) {
        volume = vol;
        System.out.println("Stereo volume=" + volume);
    }

    public int getVol() {
        return volume;
    }

    public void start() {
        System.out.println("Stereo start");
    }

    public void stop() {
        System.out.println("Stereo stop");
    }
}
