/**
 * Date:     2018/10/2816:38
 * AUTHOR:   Administrator
 */
package com.zhou.mode_009_template.no_mode;

/**
 * 2018/10/28  16:38
 * created by zhoumb
 */
public class Coffee {
    public void prepareRecipe() {
        boilWater();
        brewCoffee();
        pourInCup();
        addSugarMilk();
    }

    private void addSugarMilk() {
        System.out.println("add sugar milk");
    }

    private void pourInCup() {
        System.out.println("popur in cup");
    }

    private void brewCoffee() {
        System.out.println("brew coffee");
    }

    private void boilWater() {
        System.out.println("boil water");
    }
}
