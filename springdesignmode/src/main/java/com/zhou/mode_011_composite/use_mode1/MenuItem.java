/**
 * Date:     2018/10/2919:34
 * AUTHOR:   Administrator
 */
package com.zhou.mode_011_composite.use_mode1;

/**
 * 2018/10/29  19:34
 * created by zhoumb
 */
public class MenuItem extends MenuComponent {
    private String name;
    private String description;
    private float price;
    private boolean vegetable;

    public MenuItem(String name, String description, float price, boolean vegetable) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.vegetable = vegetable;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean isVegetable() {
        return vegetable;
    }

    public void setVegetable(boolean vegetable) {
        this.vegetable = vegetable;
    }
}
