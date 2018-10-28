/**
 * Date:     2018/10/2822:06
 * AUTHOR:   Administrator
 */
package com.zhou.mode_010_iterator.no_mode;

/**
 * 菜单
 * 2018/10/28  22:06
 * created by zhoumb
 */
public class MenuItem {
    private String name;
    private String description;
    private boolean vegetable;
    private float price;

    public MenuItem(String name, String description, boolean vegetable, float price) {
        this.name = name;
        this.description = description;
        this.vegetable = vegetable;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVegetable() {
        return vegetable;
    }

    public void setVegetable(boolean vegetable) {
        this.vegetable = vegetable;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
