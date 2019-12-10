package com.tulane.leetcode.three;

/**
 * Created by Tulane
 * 2019/12/10
 */
public class LeetCode_746 {

    public int minCostClimbingStairs1(int[] cost) {
        if(cost.length == 0 || cost.length == 1) return 0;
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }

    public int minCostClimbingStairs(int[] cost) {
        int dp_pre = 0, dp_cur = 0;
        for (int i : cost) {
            int temp = dp_cur;
            dp_cur = Math.min(dp_cur, dp_pre) + i;
            dp_pre = temp;
        }
        return Math.min(dp_cur, dp_pre);
    }
}
