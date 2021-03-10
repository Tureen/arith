//反转一个单链表。 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 进阶: 
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？ 
// Related Topics 链表 
// 👍 1559 👎 0

package leetcode.editor.cn;

import com.tulane.base.ListNode;

import javax.swing.text.TabableView;
import java.util.Stack;

//java:反转链表
public class P206ReverseLinkedList{
    public static void main(String[] args){
        Solution solution = new P206ReverseLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 本质是将交换延后, 从链的链尾开始
        // 利用栈结构保存节点信息到栈上, 先入栈的最后计算
        // 递归: 用当前节点和后继节点交换 (为什么不能和前继交换? 因为栈帧中就当前节点信息, 也无法从栈结构中获取下个节点信息, 可以修改成传入两个参数)
//        return recursion(head);
        // 迭代: 用当前节点和后继结点交换
//        return iterator(head);
        // 迭代: 用当前节点和前继结点交换
        return iterator2(head);
    }

    private ListNode recursion(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode newHead = recursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    private ListNode iterator(ListNode head) {
        Stack<ListNode> stack = new Stack();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode tail = stack.empty() ? null : stack.pop();
        while(!stack.empty()){
            ListNode tmp = stack.pop();
            tmp.next.next = tmp;
            tmp.next = null;
        }
        return tail;
    }

    private ListNode iterator2(ListNode head) {
        Stack<ListNode> stack = new Stack();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode tail = stack.empty() ? null : stack.peek();
        while(!stack.empty()){
            ListNode tmp = stack.pop();
            tmp.next = stack.empty() ? null : stack.peek();
        }
        return tail;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}