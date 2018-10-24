/**
 * Date:     2018/10/2421:48
 * AUTHOR:   Administrator
 */
package com.zhou.mode_003_decorator.coffeeShop_mode;

/**
 * 2018/10/24  21:48
 * created by zhoumb
 */
public class Milk extends Flavour {
    public Milk(Drink drink) {
        super(drink);
        super.setDescription("Milk");
        super.setPrice(2.0f);
    }
}
