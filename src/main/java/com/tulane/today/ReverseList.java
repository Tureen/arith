package com.tulane.today;

import com.tulane.base.ListNode;

/**
 *
 反转一个单链表。

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {

    /**
     * 递归法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        //当传递的节点的后继节点为空, 此节点即为尾节点, 返回此节点
        if(head == null || head.next == null) return head;
        //假设后续节点皆完成反转
        ListNode tail = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }
}
