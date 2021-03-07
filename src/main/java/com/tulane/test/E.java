package com.tulane.test;

import java.util.Stack;

public class E {

    public static int trap(int[] height) {
        if(height.length == 0) return 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < height.length; i++) {
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            if(height[stack.peek()] <= height[i]){
                stack.push(i);
            }
        }

        int sum = 0;
        int rigthHeight = height[height.length - 1];
        for (int i = height.length - 2; i >= 1; i--) {
            int leftIndex = stack.peek();
            if(leftIndex >= i){
                stack.pop();
                leftIndex = stack.peek();
            }

            int leftHeight = height[leftIndex];
            int minHeigth = leftHeight > rigthHeight ? rigthHeight : leftHeight;


            if(height[i] < minHeigth){
                sum += minHeigth - height[i];
            }
            rigthHeight = Math.max(rigthHeight, height[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{2, 0 , 2}));
    }
}
