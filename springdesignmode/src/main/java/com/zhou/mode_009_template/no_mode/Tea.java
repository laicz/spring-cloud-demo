/**
 * Date:     2018/10/2816:40
 * AUTHOR:   Administrator
 */
package com.zhou.mode_009_template.no_mode;

/**
 * 2018/10/28  16:40
 * created by zhoumb
 */
public class Tea {
    public void prepareRecipe() {
        boilWater();
        brewTea();
        pourInCup();
        addLemon();
    }

    private void boilWater() {
        System.out.println("boil water");
    }

    private void brewTea() {
        System.out.println("brew tea");
    }

    private void pourInCup() {
        System.out.println("pour in cup");
    }

    private void addLemon() {
        System.out.println("add lemon");
    }
}
