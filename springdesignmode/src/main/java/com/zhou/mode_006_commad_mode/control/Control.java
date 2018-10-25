/**
 * Date:     2018/10/2521:50
 * AUTHOR:   Administrator
 */
package com.zhou.mode_006_commad_mode.control;

/**
 * 遥控器
 * 2018/10/25  21:50
 * created by zhoumb
 */
public interface Control {
    public void onButton(int slot);

    public void offButton(int slot);
}
