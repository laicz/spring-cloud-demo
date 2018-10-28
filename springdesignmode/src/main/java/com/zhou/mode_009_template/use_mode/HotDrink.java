/**
 * Date:     2018/10/2816:45
 * AUTHOR:   Administrator
 */
package com.zhou.mode_009_template.use_mode;

/**
 * 将相同部分抽象出来
 * 步骤也抽象出来  因为步骤都是一样的
 * 2018/10/28  16:45
 * created by zhoumb
 */
public abstract class HotDrink {
    /**
     * 将冲泡的方法放在超类中
     */
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    protected abstract void addCondiments();

    protected abstract void brew();

    public void boilWater() {
        System.out.println("boiling water");
    }

    public void pourInCup() {
        System.out.println("pouring into cup");
    }
}
