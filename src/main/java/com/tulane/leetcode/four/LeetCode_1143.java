package com.tulane.leetcode.four;

/**
 * TODO 不是很透彻
 * 动态规划
 * 最长公共子序列
 * Created by Tulane
 * 2019/11/25
 */
public class LeetCode_1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] c1 = text1.toCharArray();
        char[] c2 = text2.toCharArray();
        int[][] dp = new int[c1.length + 1][c2.length + 1];

        for (int i = 1; i < c1.length + 1; i++) {
            for (int j = 1; j < c2.length + 1; j++) {
                if (c1[i - 1] == c2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[c1.length][c2.length];
    }
}
