package com.tulane.leetcode.two;

/**
 * 最长公共子序列
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_1143 {

    /**
     * 1. 将字符串转换为二维数据
     * 2. 每个位置的数额, 与缩减字符串的比对关联
     * 3. 当末尾字母相同时, 长度为两个字符串减去末尾的比对结构加1
     * 4. 当末尾字母不同时, 长度为 A字符串比对B字符串减去末尾 与 A字符串减去末尾比对B字符串 的两者长度的最大值
     * <p>
     * 递推公式 dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j])
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray(), s2 = text2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i < s1.length + 1; i++) {
            for (int j = 1; j < s2.length + 1; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[s1.length][s2.length];
    }
}
