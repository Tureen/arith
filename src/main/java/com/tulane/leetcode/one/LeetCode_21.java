package com.tulane.leetcode.one;

import com.tulane.base.ListNode;

/**
 * Created by Tulane
 * 2020/2/25
 */
public class LeetCode_21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(4);
        l1.next = l1_1;
        l1_1.next = l1_2;

        ListNode l2 = new ListNode(1);
        ListNode l2_1 = new ListNode(3);
        ListNode l2_2 = new ListNode(4);
        l2.next = l2_1;
        l2_1.next = l2_2;

        new LeetCode_21().mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode rnode = node;
        while(true){
            if(l1 == null){
                rnode.next = l2;
                break;
            }else if(l2 == null){
                rnode.next = l1;
                break;
            }else if(l1.val < l2.val){
                ListNode rnext = new ListNode(l1.val);
                rnode.next = rnext;
                rnode = rnext;
                l1 = l1.next;
            }else{
                ListNode rnext = new ListNode(l2.val);
                rnode.next = rnext;
                rnode = rnext;
                l2 = l2.next;
            }
        }
        return node.next;
    }
}
