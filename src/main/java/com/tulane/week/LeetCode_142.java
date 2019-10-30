package com.tulane.week;

import com.tulane.base.ListNode;

import java.net.HttpRetryException;

/**
 * 环形链表 II
 */
public class LeetCode_142 {

    /**
     * 非环 a
     * 环 b
     * 环点到相遇点 x
     * f: a + nb + x
     * l: a + mb + x
     * 2(a + mb + x) = a + nb + x
     * a + (m - n)b + x = 0
     * a + x = (n - m )b
     *
     * l走过的路程为 nb
     *
     * a+nb则会到达环点
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while(true){
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            low = low.next;
            if(fast == low) break;
        }
        fast = head;
        while(fast != low){
            fast = fast.next;
            low = low.next;
        }
        return fast;
    }
}
