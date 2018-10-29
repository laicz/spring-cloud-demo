/**
 * Date:     2018/10/2919:35
 * AUTHOR:   Administrator
 */
package com.zhou.mode_011_composite.use_mode1;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * 2018/10/29  19:35
 * created by zhoumb
 */
public class SubMenu extends MenuComponent {
    private ArrayList<MenuComponent> menuItems;

    public SubMenu() {
        menuItems = Lists.newArrayList();

        addItem("Apple Cookie", "Apple@candy&Cookie", true, 0.77f);
        addItem("Banana Cookie", "Banana@candy&Cookie", true, 0.77f);
        addItem("Orange Cookie", "Orange@candy&Cookie", true, 0.77f);
    }

    public void addItem(String name, String description, Boolean vegetable, Float price) {
        if (menuItems == null) {
            throw new IllegalStateException();
        }
        if (name == null || description == null || vegetable == null || price == null || price.intValue() <= 0f) {
            throw new IllegalArgumentException("");
        }
//        menuItems.add(new MenuItem(name, description, vegetable, price));
    }
}
