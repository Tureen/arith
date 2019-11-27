package com.tulane.leetcode.four;

/**
 * 动态规划 -> 斐波那契数列
 * 爬楼梯
 * Created by Tulane
 * 2019/11/25
 */
public class LeetCode_70 {

    public int climbStairs(int n) {
        if(n < 3) return n;
        int f1 = 1, f2 = 2, f3 = f1 + f2;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public int climbStairs1(int n) {
        if(n < 3) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
