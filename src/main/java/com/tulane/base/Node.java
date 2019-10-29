package com.tulane.base;

import java.util.List;

/**
 * Created by Tulane
 * 2019/10/24
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
