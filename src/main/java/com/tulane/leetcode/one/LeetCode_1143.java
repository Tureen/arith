package com.tulane.leetcode.one;

/**
 * 最长公共子序列
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_1143 {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray(), s2 = text2.toCharArray();
        // 兼容处理, 兼容i-1,j-1时为负数情况
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i < s1.length + 1; i++) {
            for (int j = 1; j < s2.length + 1; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    //边界条件: 对比末尾是否相同
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //递推公式
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[s1.length][s2.length];
    }
}
