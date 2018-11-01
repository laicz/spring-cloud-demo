/**
 * Date:     2018/10/3122:27
 * AUTHOR:   Administrator
 */
package com.zhou.mode_017_chanin_of_responsibility.use_mode;

/**
 * 购买请求
 * 2018/10/31  22:27
 * created by zhoumb
 */
public class PurchaseRequest {
    private int type;
    private int number;
    private float price;
    private int id;

    public PurchaseRequest(int type, int number, float price) {
        this.type = type;
        this.number = number;
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }


    public float getPrice() {
        return price;
    }

    public float getSum() {
        return number * price;
    }

    public int getId() {
        if (id == 0) {
            this.id = (int) Math.random() * 1000;
        }
        return this.id;
    }

}
