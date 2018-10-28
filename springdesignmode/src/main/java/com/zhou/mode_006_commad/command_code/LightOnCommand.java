/**
 * Date:     2018/10/2522:30
 * AUTHOR:   Administrator
 */
package com.zhou.mode_006_commad.command_code;

import com.zhou.mode_006_commad.device.Light;

/**
 * 具体的命令
 * 2018/10/25  22:30
 * created by zhoumb
 */
public class LightOnCommand implements Command {
    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
