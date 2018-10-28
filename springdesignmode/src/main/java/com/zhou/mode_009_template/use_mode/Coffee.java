/**
 * Date:     2018/10/2816:53
 * AUTHOR:   Administrator
 */
package com.zhou.mode_009_template.use_mode;

/**
 * 2018/10/28  16:53
 * created by zhoumb
 */
public class Coffee extends HotDrink {
    @Override
    protected void addCondiments() {
        System.out.println("brewing coffee");
    }

    @Override
    protected void brew() {
        System.out.println("adding sugar and milk");
    }
}
