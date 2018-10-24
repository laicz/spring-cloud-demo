/**
 * Date:     2018/10/2223:22
 * AUTHOR:   Administrator
 */
package com.zhou.mode_002_observer.injava;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/**
 * 2018/10/22  23:22
 * created by zhoumb
 */
public class ConcurrentCondition implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        Map<String, Float> dataMap = (Map<String, Float>) arg;
        System.out.println(this.getClass().getName() + " : " + dataMap);
    }
}
