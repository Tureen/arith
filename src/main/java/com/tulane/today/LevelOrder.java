package com.tulane.today;

import com.tulane.base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Tulane
 * 2019/11/5
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        _levelOrder(list, 0, root);
        return list;
    }

    private void _levelOrder(List<List<Integer>> list, int i, TreeNode root) {
        if(root == null) return;
        if(list.size() <= i || list.get(i) == null) list.set(i, new ArrayList<>());
        List<Integer> arr = list.get(i);
        arr.add(root.val);
        _levelOrder(list, i+1, root.left);
        _levelOrder(list, i+1, root.right);
    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue queue = new LinkedList();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> arr = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = (TreeNode) queue.poll();
                arr.add(node.val);
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            list.add(arr);
        }
        return list;
    }
}
