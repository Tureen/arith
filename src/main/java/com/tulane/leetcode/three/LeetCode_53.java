package com.tulane.leetcode.three;

/**
 * 最大子序和
 * Created by Tulane
 * 2019/11/18
 */
public class LeetCode_53 {

    /**
     * DP递推
     *
     * 当前节点的最大数和, 为上一个节点的最大和加自身, 与仅仅自身值做比较后的最大值
     *
     * DP方程: f[i] = max( a[i], f[i-1]+ a[i]) 或 max(0, f[i-1]) + a[i]
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0, dp[i-1]) + nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
