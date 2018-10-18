/**
 * Date:     2018/10/1823:19
 * AUTHOR:   Administrator
 */
package com.zhou.mode_001_strategy;

/**
 * 2018/10/18  23:19
 * created by zhoumb
 */
public abstract class Duck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    public Duck() {
    }

    public void fly() {
        flyBehavior.fly();
    }

    public void quack() {
        quackBehavior.quack();
    }

    public abstract void display();
}
