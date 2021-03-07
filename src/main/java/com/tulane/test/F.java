package com.tulane.test;

import com.tulane.base.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class F {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            final int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                final Node levelNode = queue.poll();
                levelList.add(levelNode.val);
                for (Node childNode : levelNode.children) {
                    queue.offer(childNode);
                }
            }
            list.add(levelList);
        }
        return list;
    }
}
