/**
 * Date:     2018/10/2523:20
 * AUTHOR:   Administrator
 */
package com.zhou.mode_007_adaptor.turkeyToDuck;

/**
 * 对象适配器
 * 将火鸡适配成鸭子的适配器
 * 2018/10/25  23:20
 * created by zhoumb
 */
public class TurkeyAdapter implements Duck {
    private Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        turkey.fly();
    }
}
