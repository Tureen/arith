package com.tulane.leetcode.four;

import java.util.Stack;

public class LeetCode_155 {

    private Stack stack;
    private Stack minStack;
    private int min;

    /** initialize your data structure here. */
    public LeetCode_155() {
        stack = new Stack();
        minStack = new Stack();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        min = Math.min(min, x);
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : (int) minStack.peek();
    }

    public int top() {
        return (int) stack.peek();
    }

    public int getMin() {
        return min;
    }
}
