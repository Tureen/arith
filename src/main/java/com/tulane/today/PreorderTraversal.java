package com.tulane.today;

import com.tulane.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前序
 * Created by Tulane
 * 2019/10/30
 */
public class PreorderTraversal {

    /**
     * 广度优先
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            root = (TreeNode) stack.pop();
            list.add(root.val);
            if(root.right != null) stack.push(root.right);
            if(root.left != null) stack.push(root.left);
        }
        return list;
    }

    /**
     * 深度优先遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        while(!stack.isEmpty() || root != null){
            while(root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            TreeNode node = (TreeNode) stack.pop();
            root = node.right;
        }
        return list;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        _preorderTraversal1(list, root);
        return list;
    }

    private void _preorderTraversal1(List<Integer> list, TreeNode root) {
        if(root == null) return;
        list.add(root.val);
        _preorderTraversal1(list, root.left);
        _preorderTraversal1(list, root.right);
    }
}
