package com.tulane.today;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */

/**
 * TODO 是否可以精简代码
 */
public class LargestRectangleArea {

    /**
     * 操作栈
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        Stack stack = new Stack();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty() && heights[i] < heights[(int) stack.peek()]) {
                int tmp = (int) stack.pop();
                //计算
                int area = (i - (stack.isEmpty() ? -1 : (int) stack.peek()) - 1) * heights[tmp];
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()){
            int tmp = (int)stack.pop();
            int area = (heights.length - (stack.isEmpty() ? -1 : (int) stack.peek()) - 1) * heights[tmp];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
