package com.tulane.mine;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * Created by Tulane
 * 2019/10/20
 */

import com.alibaba.fastjson.JSON;
import com.tulane.base.ListNode;

import java.util.List;

/**
 * 第一种 迭代
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode tmp = new ReverseList().reverseList(l1);
        System.out.println();
    }


    /**
     * 第四种 1 -> 2 -> 3 -> 4
     * 回环 将head.next.next = head, 即从1开始,将后继节点的next指向自己, 再将head.next置为空, 去除当前节点后继指针, 便达到1 -> 2转为2 -> 1
     * 然而由于改变了下个节点的next节点, 原链的后续节点全部丢失
     * 所以此方法需要从后向前改变
     * 利用递归法, 假设后面的节点都已反转完毕, 再进行head.next.next = head反转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null) return head;
        //先假设后续节点已反转完毕  start为递归结束语句返回的head, 在head到达尾部时, 会结束并返回
        ListNode start = reverseList(head.next);
        //进行当前节点与后继结点的反转处理
        head.next.next = head;
        head.next = null;
        //函数将尾部start节点不断返回
        return start;
    }

    /**
     * 第三种 网上的迭代 第一种精简版, 一开始便将prev置为null
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head) {
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    /**
     * 第二种 递归
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode prev = head;
        head = head.next;
        prev.next = null;
        prev = recursion(prev, head);
        return prev;
    }

    private ListNode recursion(ListNode prev, ListNode head){
        if(head == null){
            return prev;
        }
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
        return recursion(prev, head);
    }

    /**
     * 第一种 迭代 每次遍历到下一个节点时, 将上一个节点记录为此节点的next
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode prev = head;
        head = head.next;
        prev.next = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
