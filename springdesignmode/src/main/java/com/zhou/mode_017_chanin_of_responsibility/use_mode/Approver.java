/**
 * Date:     2018/10/3122:35
 * AUTHOR:   Administrator
 */
package com.zhou.mode_017_chanin_of_responsibility.use_mode;

/**
 * 批准者  （在这个批准者中含有下一个批准者，形成一个链状结构）
 * 2018/10/31  22:35
 * created by zhoumb
 */
public abstract class Approver {
    //指向下一个处理者
    Approver nextApprover;
    String name;

    public Approver(String name) {
        this.name = name;
    }

    /**
     * 处理请求的方法
     *
     * @param request
     */
    abstract void processRequest(PurchaseRequest request);

    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
}
