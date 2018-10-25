/**
 * Date:     2018/10/2522:33
 * AUTHOR:   Administrator
 */
package com.zhou.mode_006_commad_mode.command_code;

import com.zhou.mode_006_commad_mode.device.Stereo;

/**
 * 2018/10/25  22:33
 * created by zhoumb
 */
public class StereoAddVolCommand implements Command {
    private Stereo setero;

    public StereoAddVolCommand(Stereo setero) {
        this.setero = setero;
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
