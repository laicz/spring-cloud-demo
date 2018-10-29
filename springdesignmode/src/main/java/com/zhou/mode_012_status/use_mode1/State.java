/**
 * Date:     2018/10/2921:10
 * AUTHOR:   Administrator
 */
package com.zhou.mode_012_status.use_mode1;

/**
 * 状态接口拥有所有的行为的函数
 * 2018/10/29  21:10
 * created by zhoumb
 */
public interface State {
    public void insertCoin();

    public void returnCoin();

    public void turnCrank();

    public void dispense();

    public void printstate();
}
