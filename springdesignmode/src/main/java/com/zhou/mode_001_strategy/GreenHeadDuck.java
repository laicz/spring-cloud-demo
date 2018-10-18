/**
 * Date:     2018/10/1823:22
 * AUTHOR:   Administrator
 */
package com.zhou.mode_001_strategy;

/**
 * 2018/10/18  23:22
 * created by zhoumb
 */
public class GreenHeadDuck extends Duck {
    public GreenHeadDuck() {
        flyBehavior = new FlyBehavior() {
            @Override
            public void fly() {
                //由子类实现具体的
                System.out.println("绿头鸭非");
            }
        };
        quackBehavior = new QuackBehavior() {
            @Override
            public void quack() {
                //由子类实现具体的
                System.out.println("驴头角");
            }
        };
    }

    @Override
    public void display() {
        System.out.println("绿头鸭");
    }
}
