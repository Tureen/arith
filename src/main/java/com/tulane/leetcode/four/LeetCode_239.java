package com.tulane.leetcode.four;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k <= 0) return new int[0];
        Deque deque = new ArrayDeque<>();
        int[] maxs = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            // 末尾值小淘汰
            while(!deque.isEmpty() && nums[i] >= nums[(int)deque.peekLast()])
                deque.pollLast();
            // 入队
            deque.offerLast(i);
            // 首位过期淘汰
            if((int)deque.peekFirst() < (i - k + 1)) deque.pollFirst();
            // 将窗口最大值加入数组, 选择双端队列中的首位, 首位数值在双端队列中最大
            if(i - k + 1 >= 0){
                maxs[i - k + 1] = nums[(int)deque.peekFirst()];
            }
        }
        return maxs;
    }
}
