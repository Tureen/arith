package com.tulane.today;

import com.tulane.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 给定一个二叉树，返回它的中序 遍历。

 示例:

 输入: [1,null,2,3]
 1
 \
 2
 /
 3

 输出: [1,3,2]
 */
public class InorderTraversal {


    /**
     * 深度遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        while(!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = (TreeNode) stack.pop();
            list.add(node.val);
            root = node.right;
        }
        return list;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        _inorderTraversal1(list, root);
        return list;
    }

    private void _inorderTraversal1(List<Integer> list, TreeNode root) {
        if(root == null) return;
        //左树
        _inorderTraversal1(list, root.left);
        //根
        list.add(root.val);
        //右树
        _inorderTraversal1(list, root.right);
    }
}
