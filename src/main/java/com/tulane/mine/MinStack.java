package com.tulane.mine;

/**
 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

 push(x) -- 将元素 x 推入栈中。
 pop() -- 删除栈顶的元素。
 top() -- 获取栈顶元素。
 getMin() -- 检索栈中的最小元素。
 示例:

 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> 返回 -3.
 minStack.pop();
 minStack.top();      --> 返回 0.
 minStack.getMin();   --> 返回 -2.
 */

import java.util.Stack;

/**
 * 思路: 使用双栈, 一个栈为正常栈, 另一个栈为记录最小值栈
 * 最小值栈记录的是对应正常栈每个出栈位置的当前栈内最小值
 * 比如:
 * [3, 4, 2, 1] <- 正常栈
 * [3, 3, 2, 1] <- 辅助最小值栈
 * 记录辅助最小值栈时, 可以创建临时最小变量存放最小数, 每次正常栈入栈, 比对并替换最小值, 并将最小值入栈
 * 每次出栈时, 也将辅助栈出栈, 并查看栈顶元素, 得到当前正常栈的最小值, 并赋值给临时最小值变量
 */
public class MinStack {

    private Stack stack = new Stack();
    private Stack minstack = new Stack();
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);
        min = Math.min(min, x);
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
        return (int) minstack.peek();
    }
}
