/**
 * Date:     2018/11/121:20
 * AUTHOR:   Administrator
 */
package com.zhou.mode_017_chanin_of_responsibility.use_mode;

/**
 * 最终处理者
 * 2018/11/1  21:20
 * created by zhoumb
 */
public class FinalApprover extends Approver {
    private static final String FINAL_LEADER = "FinalLeader";

    public FinalApprover(String name) {
        super(FINAL_LEADER + " :" + name);
    }

    @Override
    void processRequest(PurchaseRequest request) {
        if (request.getPrice() < 15000) {
            System.out.println(" ---> this request" + request.getId() +
                    "will be handled by " + this.name + "  <----");
        } else {
            System.out.println("已经没有领导可以处理了");
        }
    }
}
