/**
 * Date:     2018/10/2822:53
 * AUTHOR:   Administrator
 */
package com.zhou.mode_010_iterator.use_mode1;

import com.zhou.mode_010_iterator.no_mode.MenuItem;

/**
 * 使用迭代器模式
 * 2018/10/28  22:53
 * created by zhoumb
 */
public class DinerMenu {
    private final static int Max_Items = 5;
    public int numberOfItems = 0;
    private MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[Max_Items];

        addItem("爆炒花蛤", "辣", false, 2.99f);
        addItem("铁板牛肉", "辣", false, 5.99f);
        addItem("水煮鱼", "辣", false, 3.99f);
        addItem("手撕包菜", "辣", true, 0.99f);

    }

    public void addItem(String name, String description, Boolean vegetable, Float price) {
        if (menuItems == null) {
            throw new IllegalStateException();
        }
        if (name == null || description == null || vegetable == null || price == null || price.intValue() <= 0f) {
            throw new IllegalArgumentException("");
        }
        if (numberOfItems >= 5) {
            throw new IndexOutOfBoundsException();
        }
        menuItems[numberOfItems++] = new MenuItem(name, description, vegetable, price);
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }
}
