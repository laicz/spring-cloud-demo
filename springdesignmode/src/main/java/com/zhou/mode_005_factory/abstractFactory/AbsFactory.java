/**
 * Date:     2018/10/2423:07
 * AUTHOR:   Administrator
 */
package com.zhou.mode_005_factory.abstractFactory;

/**
 * 工厂抽象接口
 * 2018/10/24  23:07
 * created by zhoumb
 */
public interface AbsFactory {
    Pizza createPizza(String orderType);
}
