/**
 * Date:     2018/11/1722:30
 * AUTHOR:   Administrator
 */
package com.zhou.base_006;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试Accessible属性
 * <p>
 * Accessible为false时需要检查对象的访问修饰符
 * Accessible设置为True有两种影响
 * ①：执行速度变快
 * ②：反射对象的私有属性和方法都可以访问
 * 2018/11/17  22:30
 * created by zhoumb
 */
public class AccessibleTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method getName = A.class.getDeclaredMethod("getName", new Class[]{});
        System.out.println(getName.isAccessible());

        getName.setAccessible(Boolean.TRUE);
        A a = new A();
        a.setName("Mr Lee");
        long st = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(a, new Object[]{});
        }
        System.out.println("Simple :" + (System.currentTimeMillis() - st));


        getName.setAccessible(Boolean.FALSE);
        long st1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(a, new Object[]{});
        }
        System.out.println("set accessible true ,cost time :" + (System.currentTimeMillis() - st1));
    }

    static class A {
        private String name;

        private String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }
    }
}
