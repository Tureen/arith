package com.tulane.week;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 */
public class LeetCode_84 {

    public static void main(String[] args) {
        new LeetCode_84().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }

    public int largestRectangleArea(int[] heights) {
        Deque deque = new ArrayDeque();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if (deque.isEmpty() || heights[(int) deque.peekLast()] < heights[i]) {
                deque.offerLast(i);
                continue;
            }
            while (!deque.isEmpty() && heights[(int) deque.peekLast()] > heights[i]) {
                int x = (int) deque.pollLast();
                int y = deque.isEmpty() ? -1 : (int) deque.peekLast();
                maxArea = Math.max(maxArea, (i - y - 1) * heights[x]);
            }
            deque.offerLast(i);
        }
        while (!deque.isEmpty()) {
            int x = (int) deque.pollLast();
            int y = deque.isEmpty() ? -1 : (int) deque.peekLast();
            maxArea = Math.max(maxArea, (heights.length - y - 1) * heights[x]);
        }
        return maxArea;
    }
}
