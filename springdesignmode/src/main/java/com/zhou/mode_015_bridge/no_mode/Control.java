/**
 * Date:     2018/10/2923:02
 * AUTHOR:   Administrator
 */
package com.zhou.mode_015_bridge.no_mode;

/**
 * 遥控器接口
 * 2018/10/29  23:02
 * created by zhoumb
 */
public interface Control {

    public void on();

    public void off();

    public void setChannel(int ch);

    public void setVolume(int vol);
}
