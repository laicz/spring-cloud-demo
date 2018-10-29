/**
 * Date:     2018/10/2920:28
 * AUTHOR:   Administrator
 */
package com.zhou.mode_012_status.no_mode;

/**
 * 2018/10/29  20:28
 * created by zhoumb
 */
public class CandyMachine {
    final static int SoldOutState = 0;
    final static int OnReadyState = 1;
    final static int HasCoin = 2;
    final static int SoldState = 3;

    private int state = SoldOutState;
    private int count;

    public CandyMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = OnReadyState;
        }
    }

    /**
     * 放硬币
     */
    public void insertCoin() {
        switch (state) {
            case SoldOutState:
                System.out.println("you can't sold candy,is all over");
                break;
            case OnReadyState:
                System.out.println("you have insert on coin");
                state = HasCoin;
                break;
            default:
                System.out.println("stat is error");
                break;
        }
    }

    /**
     * 退出硬币
     */
    public void returnCoin() {
        switch (state) {
            case SoldOutState:
                System.out.println("you can't sold candy,is all over");
                break;
            case OnReadyState:
                System.out.println("you have insert on coin");
                state = HasCoin;
                break;
            case HasCoin:
                System.out.println("will return on coin");
                break;
            default:
                System.out.println("stat is error");
                break;
        }
    }

    /**
     * 转动把手
     */
    public void turnCrank() {
        switch (state) {
            case SoldOutState:
                System.out.println("you can't sold candy,is all over");
                break;
            case OnReadyState:
                System.out.println("you have insert on coin");
                state = HasCoin;
                break;
            case HasCoin:
                state = SoldState;
                dispense();
                System.out.println("have good luck");
                break;
            default:
                System.out.println("stat is error");
                break;
        }
    }

    /**
     * 分糖果
     */
    private void dispense() {
        count = count - 1;
        System.out.println("a candy rolling out");
        if (count > 0) {
            state = OnReadyState;
        } else {
            System.out.println("Oo ! out of candy");
            state = SoldOutState;
        }
    }

    /**
     * 输出状态
     */
    public void printState() {
        System.out.println("当前状态：" + state);
    }
}
