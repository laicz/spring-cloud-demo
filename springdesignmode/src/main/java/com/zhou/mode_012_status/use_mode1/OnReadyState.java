/**
 * Date:     2018/10/2921:15
 * AUTHOR:   Administrator
 */
package com.zhou.mode_012_status.use_mode1;

/**
 * 2018/10/29  21:15
 * created by zhoumb
 */
public class OnReadyState implements State {
    private CandyMachine candyMachine;

    public OnReadyState(CandyMachine candyMachine) {
        this.candyMachine = candyMachine;
    }

    @Override
    public void insertCoin() {
        System.out.println("you have inserted a coin");
        candyMachine.setState(candyMachine.hasCoin);
    }

    @Override
    public void returnCoin() {
        System.out.println("you never have insert a coin");
    }

    @Override
    public void turnCrank() {
        System.out.println("you never have insert a coin");
    }

    @Override
    public void dispense() {
        System.out.println("you never have insert a coin");
    }

    @Override
    public void printstate() {
        System.out.println("you never have insert a coin");
    }
}
