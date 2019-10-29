package com.tulane.mine;

import com.tulane.base.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */

/**
 * 思路:
 * 1. 中序遍历树, 得出数组, 判断是否是有序数组
 * 2. 中序遍历每个子树, 判断其根节点, 左子节点, 右子节点的大小关系 (有问题, 其所有右子节点需要全大于根, 所有左子节点需要都小于根)
 */
public class IsValidBST {

    /**
     * 第三种 第一种的修改 递归时判断, 使用上下界限的方式
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return  _isValidBST(root, null, null);
    }

    private boolean _isValidBST(TreeNode root, Integer low, Integer up) {
        if(root == null) return true;

        if(low != null && low >= root.val) return false;
        if(up != null && up <= root.val) return false;

        //往左子节点走, 下界限可以比父节点小, 所以直接传递上次的父界限, 上界限为父节点的值
        if(!_isValidBST(root.left, low, root.val)) return false;
        //往右子节点走, 下界限必须必父节点大, 所以传递父节点值, 上界限为父界限
        if(!_isValidBST(root.right, root.val, up)) return false;
        return true;
    }

    /**
     * 第二种 入栈法 深度优先遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        List<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode node = (TreeNode) stack.pop();
            list.add(node.val);
            root = node.right;
        }

        Integer pre = null;
        for (Integer i : list) {
            if (pre != null && pre >= i) return false;
            pre = i;
        }
        return true;
    }

    /**
     * 第一种 递归 中序遍历
     *
     * @param root
     * @return
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) return true;
        List<Integer> list = new ArrayList<>();
        _isValidBST1(root, list);
        Integer pre = null;
        for (Integer i : list) {
            if (pre != null && pre >= i) return false;
            pre = i;
        }
        return true;
    }

    private void _isValidBST1(TreeNode root, List<Integer> list) {
        if (root.left != null) _isValidBST1(root.left, list);
        list.add(root.val);
        if (root.right != null) _isValidBST1(root.right, list);
    }
}
