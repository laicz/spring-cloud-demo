/**
 * Date:     2018/10/2815:03
 * AUTHOR:   Administrator
 */
package com.zhou.mode_007_adaptor.classAdaptor;

import com.zhou.mode_007_adaptor.turkeyToDuck.Duck;
import com.zhou.mode_007_adaptor.turkeyToDuck.WildTurkey;

/**
 * 类适配器
 * 将火鸡适配成鸭子
 * 实现具体的需要适配的类，而鸭子是超类
 * 2018/10/28  15:03
 * created by zhoumb
 */
public class TurkeyAdaptor2 extends WildTurkey implements Duck {

    @Override
    public void quack() {
        super.gobble();
    }

}
