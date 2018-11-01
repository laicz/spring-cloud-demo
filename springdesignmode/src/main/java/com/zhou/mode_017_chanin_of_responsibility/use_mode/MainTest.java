/**
 * Date:     2018/11/121:22
 * AUTHOR:   Administrator
 */
package com.zhou.mode_017_chanin_of_responsibility.use_mode;

/**
 * 2018/11/1  21:22
 * created by zhoumb
 */
public class MainTest {
    public static void main(String[] args) {
        FinalApprover finalApprover = new FinalApprover("li");
        DepartmentApprover departmentApprover = new DepartmentApprover("feng");
        departmentApprover.setNextApprover(finalApprover);
        GroupApprover groupApprover = new GroupApprover("yi");
        groupApprover.nextApprover = departmentApprover;

        groupApprover.processRequest(new PurchaseRequest(1,10,15000f));
    }
}
