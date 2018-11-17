/**
 * Date:     2018/11/1723:05
 * AUTHOR:   Administrator
 */
package com.zhou.base_006.dynamicProxy;

import com.alibaba.fastjson.JSON;
import netscape.javascript.JSObject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 自定义动态代理类
 * 2018/11/17  23:05
 * created by zhoumb
 */
public class MyInvocationHandler implements InvocationHandler {
    //含有需要代理执行的对象
    private Object target;

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(JSON.toJSONString(proxy));
        System.out.println("执行前.........");
        Object invoke = method.invoke(target, args);
        System.out.println("执行后.........");
        return invoke;
    }
}
