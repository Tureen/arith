package com.tulane.mine;

/**
 *
 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。

 说明：不允许修改给定的链表。

  

 示例 1：

 输入：head = [3,2,0,-4], pos = 1
 输出：tail connects to node index 1
 解释：链表中有一个环，其尾部连接到第二个节点。

 */

import com.tulane.base.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 思路:
 * 1. 暴力法 存入hash
 */
public class DetectCycle {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode3;
        new DetectCycle().detectCycle(listNode1);
    }

    /**
     * 第二种  网上看的快慢指针
     * 自己的理解:
     * 假设非环部分长度为a, 环的长度为b, 环首与快慢指针的环内相遇点距离x
     * 快慢指针相遇时走过的长度:
     * slow: a + nb + x
     * fast: a + mb + x
     * 由于快指针比慢指针多走两倍, 所以得出:
     * -> a + mb + x = 2(a + nb + x)
     * -> a + x = (m - n) b
     * 所以慢指针走过的路径:
     * -> a + nb + x = mb - nb + nb = mb
     * 所以慢指针继续走a步即可到达环首:
     * -> a + mb
     *
     * 程序中的实现
     * 第一阶段: 快慢指针相遇
     * 第二阶段: 复制慢指针并从链表头开始, 慢慢指针相遇 (相遇时即是都走了 a步 <=> 非环距离 <=> 链表头到环首距离))
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        //第一阶段
        while(true){
            if(fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        //第二阶段
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }


    /**
     * 第一种 暴力法
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head != null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
