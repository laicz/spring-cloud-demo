/**
 * Date:     2018/10/2521:52
 * AUTHOR:   Administrator
 */
package com.zhou.mode_006_commad_mode.no_mode;

import com.zhou.mode_006_commad_mode.control.Control;
import com.zhou.mode_006_commad_mode.device.Light;
import com.zhou.mode_006_commad_mode.device.Stereo;

/**
 * 具体控制类
 * 2018/10/25  21:52
 * created by zhoumb
 */
public class TraditionControl implements Control {
    Light light;
    Stereo stereo;

    public TraditionControl(Light light, Stereo stereo) {
        this.light = light;
        this.stereo = stereo;
    }

    @Override
    public void onButton(int slot) {
        switch (slot) {
            case 0:
                light.on();
                break;
            case 1:
                stereo.on();
                break;
            case 2:
                int vol = stereo.getVol();
                if (vol < 11) {
                    stereo.setVol(++vol);
                }
                break;
        }
    }

    @Override
    public void offButton(int slot) {
        switch (slot) {
            case 0:
                light.off();
                break;
            case 1:
                stereo.off();
                break;
            case 2:
                int vol = stereo.getVol();
                if (vol < 11) {
                    stereo.setVol(--vol);
                }
                break;
        }
    }
}
