/**
 * Date:     2018/10/2822:47
 * AUTHOR:   Administrator
 */
package com.zhou.mode_010_iterator.use_mode1;

import com.google.common.collect.Lists;
import com.zhou.mode_010_iterator.no_mode.MenuItem;

import java.util.ArrayList;

/**
 * 2018/10/28  22:47
 * created by zhoumb
 */
public class Waitress {
    private ArrayList<Iterator> iterators = Lists.newArrayList();

    public Waitress() {
    }

    public void addIterator(Iterator iterator) {
        iterators.add(iterator);
    }

    public void printMenu() {
        for (int i = 0; i < iterators.size(); i++) {
            Iterator iterator = iterators.get(i);
            while (iterator.hasNext()) {
                MenuItem menuItem = (MenuItem) iterator.next();
            }
        }
    }
}
