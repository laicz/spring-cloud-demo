/**
 * Date:     2018/10/2822:52
 * AUTHOR:   Administrator
 */
package com.zhou.mode_010_iterator.use_mode1;

import com.google.common.collect.Lists;
import com.zhou.mode_010_iterator.no_mode.MenuItem;

import java.util.List;

/**
 * 使用迭代器模式
 * 2018/10/28  22:52
 * created by zhoumb
 */
public class CakeHouseMenu {
    private List<MenuItem> menuItems;

    public CakeHouseMenu() {
        menuItems = Lists.newArrayList();

        addItem("KFC Cake Breakfast", "boiled eggs&&cabbage", true, 3.99f);
        addItem("MDL Cake Breakfast", "fried eggs&&toast", false, 3.59f);
        addItem("Stawberry Cake", "fresh Stawberry", true, 3.29f);
        addItem("Regular Cake Breakfast", "toast&&au", true, 2.59f);


    }

    public void addItem(String name, String description, Boolean vegetable, Float price) {
        if (menuItems == null) {
            throw new IllegalStateException();
        }
        if (name == null || description == null || vegetable == null || price == null || price.intValue() <= 0f) {
            throw new IllegalArgumentException("");
        }
        menuItems.add(new MenuItem(name, description, vegetable, price));
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public Iterator iterator() {
        return new CakeHourseIterator();
    }

    //使用一个内部类实现迭代器
    class CakeHourseIterator implements Iterator {
        private int position;

        @Override
        public boolean hasNext() {
            return position < menuItems.size();
        }

        @Override
        public Object next() {
            return menuItems.get(position++);
        }
    }
}
