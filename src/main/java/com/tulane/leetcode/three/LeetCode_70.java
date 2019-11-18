package com.tulane.leetcode.three;

/**
 * 爬楼梯
 * Created by Tulane
 * 2019/11/18
 */
public class LeetCode_70 {

    /**
     * DP递推
     *
     * 当前台阶的值为 上一步台阶的两种走法的累加
     * 状态数组: f[i]
     * DP方程: f[i] = f[i-1] + f[i-2]
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n < 3) return n;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
