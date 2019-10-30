package com.tulane.week;

import com.tulane.base.ListNode;

/**
 * 反转链表
 */
public class LeetCode_206 {

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return first;
    }
}
