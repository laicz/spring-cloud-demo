/**
 * Date:     2018/11/223:11
 * AUTHOR:   Administrator
 */
package com.zhou.mode_020_mediator.use_mode;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 具体的中介者
 * 2018/11/2  23:11
 * created by zhoumb
 */
public class ConcreateMediator implements Mediator {
    private static Map<String, Colleague> colleagueMap;
    private static Map<String, String> interMap;

    public ConcreateMediator() {
        colleagueMap = Maps.newHashMap();
        interMap = Maps.newHashMap();
    }

    @Override
    public void register(String colleagueName, Colleague colleague) {
        colleagueMap.put(colleagueName, colleague);

        if (colleague instanceof Alarm) {
            interMap.put("Alarm", colleagueName);
        } else if (colleague instanceof CoffeeMachine) {
            interMap.put("CoffeeMachine", colleagueName);
        } else if (colleague instanceof TV) {
            interMap.put("TV", colleagueName);
        } else if (colleague instanceof Curtains) {
            interMap.put("Curtains", colleagueName);
        }
    }

    @Override
    public void getMessage(int stateChange, String colleagueName) {

    }

    @Override
    public void sendMessage() {

    }
}
