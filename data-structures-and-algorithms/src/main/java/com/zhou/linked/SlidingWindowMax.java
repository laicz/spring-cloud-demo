/**
 * Date:     2018/11/1221:36
 * AUTHOR:   Administrator
 */
package com.zhou.linked;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 滑动窗口最大值
 * 2018/11/12  21:36
 * created by zhoumb
 */
public class SlidingWindowMax {
    private static final int[] array = {13, 1, 2, 4, 3, 7, 90, 22, 15, 26};

    /**
     * 使用双向队列来获取滑动窗口的最大值
     */
    public static void dequeMax() {
        int index = 0;
        Deque<Integer> max = new ArrayDeque(3);
        for (int i = 0; i < array.length; i++) {
            while (!max.isEmpty() && array[max.getLast()] <= array[i]) {
                max.pollLast();
                max.add(i);
            }
        }
    }
}
