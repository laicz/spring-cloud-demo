/**
 * Date:     2018/10/2921:13
 * AUTHOR:   Administrator
 */
package com.zhou.mode_012_status.use_mode1;

/**
 * 糖果机的行为都是由状态来实现
 * 2018/10/29  21:13
 * created by zhoumb
 */
public class CandyMachine {
    State soldOutState;
    State onReadyState;
    State hasCoin;
    State soldState;
    State winnerState;
    private State state;
    private int count = 0;

    public CandyMachine(int count) {
        this.count = count;

        this.soldOutState = new SoldOutState();
        this.onReadyState = new OnReadyState(null);
        this.hasCoin = new HasCoinState();
        this.soldState = new SoldState();
        this.winnerState = new WinnerState();
        if (count > 0) {
            this.state = this.onReadyState;
        } else {
            this.state = this.soldOutState;
        }
    }

    public void setState(State state) {
        this.state = state;
    }

    public void insertCoin() {
        this.state.insertCoin();
    }

    public void returnCoin() {
        this.state.returnCoin();
    }

    public void turnCrank() {
        this.state.turnCrank();
        this.state.dispense();
    }

}
