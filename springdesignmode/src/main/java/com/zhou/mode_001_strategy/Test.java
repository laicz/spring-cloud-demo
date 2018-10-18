/**
 * Date:     2018/10/1823:27
 * AUTHOR:   Administrator
 */
package com.zhou.mode_001_strategy;

/**
 * 2018/10/18  23:27
 * created by zhoumb
 */
public class Test {
    public static void main(String[] args) {
        Duck duck = new GreenHeadDuck();
        duck.quack();
        duck.fly();
        duck.display();
    }
}
