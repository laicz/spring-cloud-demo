/**
 * Date:     2018/11/721:59
 * AUTHOR:   Administrator
 */
package com.zhou.linked;

import java.util.List;

/**
 * 单向链表
 * 2018/11/7  21:59
 * created by zhoumb
 */
public class ListNodeSolution {

    /**
     * 单向链表操作
     * （便利法）
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 相邻的两个链表反转
     *
     * @param head
     */
    public static ListNode llreverseList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (head.next != null && head.next.next != null) {
            ListNode first = head.next;
            ListNode second = head.next.next;
            first.next = second.next;
            curr.next = second;
            curr.next.next = first;
            curr = curr.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(5, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(1, new ListNode(0, null))))));
//        print(listNode);
        ListNode listNode1 = llreverseList(listNode);
        print(listNode1);
    }

    public static void print(ListNode listNode) {
        while (listNode.next != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println(listNode.val);
    }
}
