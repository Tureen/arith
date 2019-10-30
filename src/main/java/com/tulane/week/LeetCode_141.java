package com.tulane.week;

import com.tulane.base.ListNode;

/**
 * 环形链表
 *
 */
public class LeetCode_141 {

    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode fast = head.next;
        ListNode low = head;
        while(low != fast){
            if(fast == null || fast.next == null) return false;
            fast = fast.next.next;
            low = low.next;
        }
        return true;
    }
}
