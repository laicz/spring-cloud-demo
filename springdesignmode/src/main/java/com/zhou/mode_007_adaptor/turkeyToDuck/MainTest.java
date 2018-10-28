/**
 * Date:     2018/10/2523:21
 * AUTHOR:   Administrator
 */
package com.zhou.mode_007_adaptor.turkeyToDuck;

/**
 * 2018/10/25  23:21
 * created by zhoumb
 */
public class MainTest {
    public static void main(String[] args) {
        Turkey turkey = new WildTurkey();
        TurkeyAdapter turkeyAdapter = new TurkeyAdapter(turkey);
        turkeyAdapter.quack();
        turkeyAdapter.fly();
    }
}
