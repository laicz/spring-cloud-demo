/**
 * Date:     2018/10/2420:31
 * AUTHOR:   Administrator
 */
package com.zhou.mode_002_observer.injava;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * 2018/10/24  20:31
 * created by zhoumb
 */
public class ForcastCondition implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Map<String, Float> dataMap = (Map<String, Float>) arg;
        System.out.println(this.getClass().getName() + " : " + dataMap);
    }
}
