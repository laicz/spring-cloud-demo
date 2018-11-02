/**
 * Date:     2018/11/222:49
 * AUTHOR:   Administrator
 */
package com.zhou.mode_020_mediator.use_mode;

/**
 * 中介者 维护各个类之间的关系
 * 2018/11/2  22:49
 * created by zhoumb
 */
public interface Mediator {
    /**
     * 注册同事
     * @param colleagueName
     * @param colleague
     */
    void register(String colleagueName, Colleague colleague);

    /**
     * 获取消息
     * @param stateChange
     * @param colleagueName
     */
    void getMessage(int stateChange, String colleagueName);

    /**
     * 发送消息
     */
    void sendMessage();
}
