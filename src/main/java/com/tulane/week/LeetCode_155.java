package com.tulane.week;

/**
 * 最小栈
 */

import java.util.Stack;

/**
 * 双栈法
 */
public class LeetCode_155 {

    private Stack stack = new Stack();
    private Stack minStack = new Stack();
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
//    public MinStack() {
//
//    }

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
