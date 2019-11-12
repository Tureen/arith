package com.tulane.week;

import com.tulane.base.ListNode;

import java.util.List;

/**
 * K 个一组翻转链表
 * Created by Tulane
 * 2019/11/10
 */
public class LeetCode_25 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        ListNode n = new LeetCode_25().reverseKGroup(l1, 6);

        show(n);
    }

    public static void show(ListNode n) {
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int _k = k;
        ListNode nextK = head;
        while (--_k >= 0) {
            if(nextK == null) return head;
            nextK = nextK.next;
        }
        ListNode node = reverseKGroup(nextK, k);
        ListNode first = reverse(head, k, 0);
        head.next = node;
        return first;
    }

    private ListNode reverse(ListNode head, int k, int i) {
        if (i >= k - 1 || head == null || head.next == null) return head;
        ListNode tail = reverse(head.next, k, i + 1);
        head.next.next = head;
        head.next = null;
        return tail;
    }
}
