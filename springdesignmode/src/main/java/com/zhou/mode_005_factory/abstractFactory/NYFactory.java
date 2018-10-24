/**
 * Date:     2018/10/2423:10
 * AUTHOR:   Administrator
 */
package com.zhou.mode_005_factory.abstractFactory;

/**
 * 2018/10/24  23:10
 * created by zhoumb
 */
public class NYFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        if ("cheese".equals(orderType)) {
            //创建一个纽约下的皮萨雷
        } else {
            //创建披萨
        }
        return null;
    }
}
