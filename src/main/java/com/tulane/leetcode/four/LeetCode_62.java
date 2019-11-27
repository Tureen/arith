package com.tulane.leetcode.four;

import java.util.Arrays;

/**
 * 动态规划
 * 不同路径
 * Created by Tulane
 * 2019/11/24
 */
public class LeetCode_62 {
    public static void main(String[] args) {
        new LeetCode_62().uniquePaths(7, 3);
    }


    /**
     * DP递推
     *
     * f[i,j] = Max(f[i-1,j], f[i,j-1]) + 1
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        return dp[n - 1];
    }
}
