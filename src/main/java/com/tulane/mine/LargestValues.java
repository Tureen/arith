package com.tulane.mine;

/**
 * 您需要在二叉树的每一行中找到最大的值。

 示例：

 输入:

 1
 / \
 3   2
 / \   \
 5   3   9

 输出: [1, 3, 9]

 */

import com.tulane.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先遍历
 */
public class LargestValues {

    /**
     * 广度优先
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue queue = new LinkedList();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < size; i++){
                TreeNode node = (TreeNode) queue.poll();
                max = Math.max(max, node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            list.add(max);
        }
        return list;
    }
}
