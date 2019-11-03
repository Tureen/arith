package com.tulane.mine;

import com.alibaba.fastjson.JSON;
import com.tulane.base.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回其层次遍历结果：

 [
 [3],
 [9,20],
 [15,7]
 ]

 */

/**
 * 思考: 广度遍历, 队列维护
 */
public class LevelOrder {

    public static void main(String[] args) {
//        [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(JSON.toJSON(new LevelOrder().levelOrder(root)));
    }

    /**
     * 深度优先
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        _levelOrde(list, 0, root);
        return list;
    }

    private void _levelOrde(List<List<Integer>> list, int level, TreeNode root) {
        if(root == null) return;
        if(level >= list.size()) list.add(level, new ArrayList<>());
        list.get(level).add(root.val);
        _levelOrde(list, level + 1, root.left);
        _levelOrde(list, level + 1, root.right);
    }

    /**
     * 广度优先, 逐层遍历(优化: 指针代替暂存数组)
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrde2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue queue = new ArrayDeque();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> breadthList = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode treeNode = (TreeNode) queue.poll();
                breadthList.add(treeNode.val);
                if(treeNode.left != null ) queue.offer(treeNode.left);
                if(treeNode.right != null ) queue.offer(treeNode.right);
            }
            list.add(breadthList);
        }
        return list;
    }

    /**
     * 广度优先, 逐层遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue queue = new ArrayDeque();
        queue.add(root);
        while(!queue.isEmpty()){
            List<TreeNode> breadthList = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode node = (TreeNode) queue.poll();
                breadthList.add(node);
            }
            // 层集合输出数字
            List<Integer> breadthValList = new ArrayList<>();
            for (TreeNode treeNode : breadthList) {
                breadthValList.add(treeNode.val);
                if(treeNode.left != null ) queue.offer(treeNode.left);
                if(treeNode.right != null ) queue.offer(treeNode.right);
            }
            list.add(breadthValList);
        }
        return list;
    }

}
