package com.tulane.today;

import java.util.Stack;

/**
 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。

 */
public class MinStack {

    /**
     * TODO 未达到最小时间, 可以看题解改进
     */
    private Stack stack;
    private Stack minstack;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        minstack = new Stack();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        min = Math.min(min, x);
        stack.push(x);
        minstack.push(min);
    }

    public void pop() {
        stack.pop();
        minstack.pop();
        if(minstack.isEmpty()){
            min = Integer.MAX_VALUE;
        }else {
            min = (int) minstack.peek();
        }
    }

    public int top() {
        return (int) stack.peek();
    }

    public int getMin() {
        return min;
    }
}
