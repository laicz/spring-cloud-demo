/**
 * Date:     2018/11/1921:05
 * AUTHOR:   Administrator
 */
package com.zhou.base_006.dynamicProxy;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 快速失败案例
 * 2018/11/19  21:05
 * created by zhoumb
 */
public class FailFaseCase {
    public static void main(String[] args) {
        listFailFast();
    }

    public static void listFailFast() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }
        Iterator<String> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            if (i == 3) {
                list.remove(3);
            }
            System.out.println(iterator.next());
            i++;
        }
    }
}
