/**
 * Date:     2018/10/2421:42
 * AUTHOR:   Administrator
 */
package com.zhou.mode_003_decorator.coffeeShop_mode;

/**
 * 装饰者必须需要实现超类
 * 2018/10/24  21:42
 * created by zhoumb
 */
public class Flavour extends Drink {
    private Drink drink;

    public Flavour(Drink drink) {
        this.drink = drink;
    }

    @Override
    public float cost() {
        return super.getPrice() + drink.getPrice();
    }

    @Override
    public String getDescription() {
        return drink.getDescription() + " : " + drink.getPrice() + "&&" + super.getDescription() + " : " + super.getPrice();
    }
}
