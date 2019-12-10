package com.tulane.leetcode.two;

/**
 * Created by Tulane
 * 2019/12/8
 */
public class LeetCode_746 {

    public int minCostClimbingStairs(int[] cost) {
        int dp_cur = 0, dp_pre = 0;
        for (int i : cost) {
            int temp = dp_cur;
            dp_cur = Math.min(dp_cur, dp_pre) + i;
            dp_pre = temp;
        }
        return Math.min(dp_cur, dp_pre);
    }
}
