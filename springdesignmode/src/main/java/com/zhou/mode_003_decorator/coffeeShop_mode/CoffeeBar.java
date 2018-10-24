/**
 * Date:     2018/10/2421:51
 * AUTHOR:   Administrator
 */
package com.zhou.mode_003_decorator.coffeeShop_mode;

/**
 * 2018/10/24  21:51
 * created by zhoumb
 */
public class CoffeeBar {
    public static void main(String[] args) {
        Drink drink = new Decaf();
        System.out.println("decaf:" + drink.getDescription());
        System.out.println("decaf:" + drink.cost());

        System.out.println("--------------------------");
        Drink drink1 = new Milk(new Espresso());
        System.out.println("espresso:" + drink1.getDescription());
        System.out.println("espresso:" + drink1.cost());
    }
}
