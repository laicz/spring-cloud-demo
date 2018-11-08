/**
 * Date:     2018/11/722:01
 * AUTHOR:   Administrator
 */
package com.zhou.linked;

/**
 * 单向链表
 * 2018/11/7  22:01
 * created by zhoumb
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
