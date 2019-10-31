package com.tulane.today;

import com.tulane.base.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Tulane
 * 2019/10/30
 */
public class Postorder {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        _postorder(list, root);
        return list;
    }

    private void _postorder(List<Integer> list, Node root) {
        if(root == null) return;
        if(root.children != null && root.children.size() > 0){
            for (Node child : root.children) {
                _postorder(list, child);
            }
        }
        list.add(root.val);
    }

    /**
     * 广度优先
     * 类似前序, 前序的反向, 根右左
     * @param root
     * @return
     */
    public List<Integer> postorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            root = (Node) stack.pop();
            list.add(0, root.val);
            if(root.children != null && root.children.size() > 0){
                for (Node child : root.children) {
                    stack.push(child);
                }
            }
        }
        return list;
    }
}
