/**
 * Date:     2018/10/2920:44
 * AUTHOR:   Administrator
 */
package com.zhou.mode_012_status.no_mode;

/**
 * 2018/10/29  20:44
 * created by zhoumb
 */
public class MainTest {
    public static void main(String[] args) {
        CandyMachine candyMachine = new CandyMachine(1);

        candyMachine.printState();
        candyMachine.turnCrank();
        candyMachine.printState();
        candyMachine.insertCoin();
        candyMachine.printState();
        candyMachine.turnCrank();
        candyMachine.printState();
        candyMachine.turnCrank();
        candyMachine.insertCoin();
        candyMachine.turnCrank();
        candyMachine.insertCoin();
        candyMachine.printState();
    }
}
