package com.tulane.leetcode.three;

import com.tulane.base.ListNode;

import java.util.Stack;

/**
 * Created by Tulane
 * 2020/2/24
 */
public class Leet_206 {

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode tail = stack.pop();
        ListNode pre = null;
        while(!stack.empty()){
            pre = stack.pop();
            pre.next.next = pre;
        }
        pre.next = null;
        return tail;
    }
}
