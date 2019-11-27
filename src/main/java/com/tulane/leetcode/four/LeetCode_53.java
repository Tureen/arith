package com.tulane.leetcode.four;

/**
 * 动态规划
 * 最大子序和
 * Created by Tulane
 * 2019/11/25
 */
public class LeetCode_53 {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int res = dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], 0) + nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
