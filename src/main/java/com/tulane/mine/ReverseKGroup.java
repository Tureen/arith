package com.tulane.mine;

import com.tulane.base.ListNode;

import java.util.List;

/**
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 说明 :
 * <p>
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */

/**
 * 思路:
 * 1.与反转链表 & 两两反转链表 的思路一致, 递归法, 假设父节点已完成反转
 * 2.顺序反转与两两反转, 都只有一次的指针位置交换, 当由一节点变两节点时, 会保留个临时变量存储将要被反转的元素
 * 3.当K个翻转时, 可以假设是一条K长的链翻转
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode n = new ReverseKGroup().reverseKGroup(l1, 3);

        show(n);
    }

    public static void show(ListNode n) {
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    /**
     * 递归法, 分成两个阶段
     * 1. 分为N个K长的链, 假设这些链已完成反转 -> 使用时使用反转单链的递归写法
     * 2. 将N个K长的链拼接, 拼接时递归假设后面的链已完成拼接
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        int i = k;
        ListNode nextNode = head;
        if(nextNode == null) return head;
        while (--i >= 0) {
            if(nextNode == null) return head;
            nextNode = nextNode.next;
        }
        ListNode leftNode = reverseKGroup(nextNode, k);
        //反转
        ListNode node = reverseK(head, k);
        head.next = leftNode;
        return node;
    }

    /**
     * 反转一个链表上的k长元素
     * @param head
     * @param k
     * @return
     */
    private ListNode reverseK(ListNode head, int k) {
        if (--k == 0) return head;
        ListNode start = reverseK(head.next, k);
        head.next.next = head;
        head.next = null;
        return start;
    }
}
