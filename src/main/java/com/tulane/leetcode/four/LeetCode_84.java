package com.tulane.leetcode.four;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_84 {

    public int largestRectangleArea(int[] heights) {
        // 双端队列存储递增元素
        Deque deque = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while(!deque.isEmpty() && heights[(int)deque.peekLast()] > heights[i]){
                int indexOfHigh = (int) deque.pollLast();
                int left = deque.isEmpty() ? -1 : (int) deque.peekLast();
                maxArea = Math.max(maxArea, (i - left - 1) * heights[indexOfHigh]);
            }
            deque.offerLast(i);
        }
        while(!deque.isEmpty()){
            int indexOfHigh = (int) deque.pollLast();
            int left = deque.isEmpty() ? -1 : (int) deque.peekLast();
            maxArea = Math.max(maxArea, (heights.length - left - 1) * heights[indexOfHigh]);
        }
        return maxArea;
    }
}
