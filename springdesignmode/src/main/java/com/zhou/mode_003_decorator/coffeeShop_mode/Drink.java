/**
 * Date:     2018/10/2421:25
 * AUTHOR:   Administrator
 */
package com.zhou.mode_003_decorator.coffeeShop_mode;

/**
 * 2018/10/24  21:25
 * created by zhoumb
 */
public abstract class Drink {
    public String description = "";
    public float price = 0f;

    public String getDescription() {
        return description + "-" + this.getPrice();
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float cost();
}
