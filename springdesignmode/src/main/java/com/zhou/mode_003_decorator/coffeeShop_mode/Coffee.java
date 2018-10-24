/**
 * Date:     2018/10/2421:32
 * AUTHOR:   Administrator
 */
package com.zhou.mode_003_decorator.coffeeShop_mode;

/**
 * 这是主体
 * 2018/10/24  21:32
 * created by zhoumb
 */
public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
