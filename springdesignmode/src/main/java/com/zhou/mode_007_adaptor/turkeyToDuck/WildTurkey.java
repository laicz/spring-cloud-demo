/**
 * Date:     2018/10/2523:18
 * AUTHOR:   Administrator
 */
package com.zhou.mode_007_adaptor.turkeyToDuck;

/**
 * 2018/10/25  23:18
 * created by zhoumb
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("gu gu ");
    }

    @Override
    public void fly() {
        System.out.println("i am a wild turkey fly");
    }
}
