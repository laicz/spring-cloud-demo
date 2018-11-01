/**
 * Date:     2018/10/3123:04
 * AUTHOR:   Administrator
 */
package com.zhou.mode_017_chanin_of_responsibility.use_mode;

/**
 * 组长处理者
 * 2018/10/31  23:04
 * created by zhoumb
 */
public class GroupApprover extends Approver {
    private static final String GROUP_LEADER = "GroupLeader";
    private static final int GROUP_LEADER_PRICE = 5000;

    public GroupApprover(String name) {
        super(GROUP_LEADER + ":" + name);
    }

    @Override
    void processRequest(PurchaseRequest request) {
        if (request.getSum() < GROUP_LEADER_PRICE) {
            System.out.println(" ---> this request" + request.getId() +
                    "will be handled by " + this.name + "  <----");
        } else {
            //如果自己处理不了，则传入下个处理者
            this.nextApprover.processRequest(request);
        }
    }
}
