/**
 * Date:     2018/11/1723:11
 * AUTHOR:   Administrator
 */
package com.zhou.base_006.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 2018/11/17  23:11
 * created by zhoumb
 */
public class DynamicProxyMain {
    public static void main(String[] args) {
        Hello hello = new HelloImpl();
        InvocationHandler invocationHandler = new MyInvocationHandler(hello);
        Hello helloProxy =(Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), hello.getClass().getInterfaces(), invocationHandler);
        helloProxy.sayHello();
    }
}
