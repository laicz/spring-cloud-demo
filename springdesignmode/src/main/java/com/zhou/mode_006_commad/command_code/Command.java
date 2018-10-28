/**
 * Date:     2018/10/2522:28
 * AUTHOR:   Administrator
 */
package com.zhou.mode_006_commad.command_code;

/**
 * 将命令抽象成一个接口（抽象类也行）
 * 2018/10/25  22:28
 * created by zhoumb
 */
public interface Command {
    void execute();

    void undo();
}
