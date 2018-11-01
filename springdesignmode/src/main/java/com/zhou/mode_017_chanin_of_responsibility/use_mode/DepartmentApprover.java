/**
 * Date:     2018/10/3123:17
 * AUTHOR:   Administrator
 */
package com.zhou.mode_017_chanin_of_responsibility.use_mode;

/**
 * 部门处理者
 * 2018/10/31  23:17
 * created by zhoumb
 */
public class DepartmentApprover extends Approver {
    public static final String DEPART_LEADER = "DepartLeader";
    public static final int DEPART_LEADER_PRICE = 10000;

    public DepartmentApprover(String name) {
        super(DEPART_LEADER + " :" + name);
    }

    @Override
    void processRequest(PurchaseRequest request) {
        if (request.getPrice() < DEPART_LEADER_PRICE) {
            System.out.println(" ---> this request" + request.getId() +
                    "will be handled by " + this.name + "  <----");
        } else {
            //如果自己处理不了  则传到下个处理器上
            this.nextApprover.processRequest(request);
        }
    }
}
