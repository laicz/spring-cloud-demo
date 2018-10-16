/**
 * Date:     2018/10/168:01
 * AUTHOR:   Administrator
 */
package com.zhou.springcloudjms.base;

import org.junit.Test;

/**
 * 2018/10/16  8:01
 * created by zhoumb
 */
public class BaseStudy {

    @Test
    public void yuyu() {
        int a = 3;
        int b = 4;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);
    }
}
