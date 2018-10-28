/**
 * Date:     2018/10/2816:54
 * AUTHOR:   Administrator
 */
package com.zhou.mode_009_template.use_mode;

/**
 * 2018/10/28  16:54
 * created by zhoumb
 */
public class Tea extends HotDrink {
    @Override
    protected void addCondiments() {
        System.out.println("add lemon");
    }

    @Override
    protected void brew() {
        System.out.println("brew tea");
    }
}
