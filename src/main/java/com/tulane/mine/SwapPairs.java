package com.tulane.mine;

import com.alibaba.fastjson.JSON;
import com.tulane.base.ListNode;

/**
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.

 */

/**
 * TODO 之后可考虑用非递归实现
 * 思考, 类型反转链表, 用递归解决
 */
public class SwapPairs {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(JSON.toJSON(listNode1));
        new SwapPairs().swapPairs(listNode1);

        System.out.println(JSON.toJSON(listNode1));
    }

    /**
     * 第一种的精简化 递归法
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode listNode = swapPairs(head.next.next);
        ListNode nextNode = head.next;
        nextNode.next = head;
        head.next = listNode;
        return nextNode;
    }

    /**
     * 第一种 递归法, 假设下两个节点已完成反转, 并将最左节点返回, 只需自身反转并连接上下两个反转节点
     * 关键点:
     * 1. 递归的结束判断, 当下下个节点不存在则结束, 并返回null节点作为反转节点的下个连接
     * 2. 递归的返回值要是反转后的第一个节点, 作为调用递归的节点的下个连接点
     * 3. 递归的最浅调用的返回值才是真正的方法返回值, 根据第二个关键点, 最浅调用返回的即是反转后的头结点, 所以直接返回即可, 无需创建新的递归方法用于分隔返回值
     * @param head
     * @return
     */
    public ListNode swapPairs1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode listNode = null;
        if(head.next.next != null) listNode = swapPairs1(head.next.next);
        ListNode nextNode = head.next;
        nextNode.next = head;
        head.next = listNode;
        return nextNode;
    }

//    private ListNode recursionParent(ListNode head){
//        ListNode listNode = null;
//        if(head.next.next != null) listNode = recursionParent(head.next.next);
//        ListNode nextNode = head.next;
//        nextNode.next = head;
//        head.next = listNode;
//        return nextNode;
//    }
}
