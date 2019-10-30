package com.tulane.today;

import com.tulane.base.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Tulane
 * 2019/10/30
 */
public class Preorder {

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        _preorder(list, root);
        return list;
    }

    private void _preorder(List<Integer> list, Node root) {
        if(root == null) return;
        list.add(root.val);
        if(root.children != null && root.children.size() > 0){
            for (Node child : root.children) {
                _preorder(list, child);
            }
        }
    }

    /**
     * 广度优先
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            root = (Node) stack.pop();
            list.add(root.val);
            if(root.children != null && root.children.size() > 0){
                for (int i = root.children.size() - 1; i >= 0; i--) {
                    stack.push(root.children.get(i));
                }
            }
        }
        return list;
    }
}
