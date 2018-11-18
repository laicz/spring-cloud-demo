/**
 * Date:     2018/11/1822:55
 * AUTHOR:   Administrator
 */
package com.zhou.base_006.dynamicProxy;

import java.util.Arrays;
import java.util.Random;

/**
 * 数组排序测试
 * 2018/11/18  22:55
 * created by zhoumb
 */
public class ArraySortCase {
    public static void main(String[] args) {
        int[] ints = new int[10000000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = new Random().nextInt(ints.length);
        }

        int[] clone = ints.clone();
        int[] clone1 = ints.clone();

        long st = System.currentTimeMillis();
        Arrays.sort(clone);
        System.out.println("耗时：" + (System.currentTimeMillis() - st));

        long st2 = System.currentTimeMillis();
        Arrays.parallelSort(clone1);
        System.out.println("耗时：" + (System.currentTimeMillis() - st2));
    }
}
