package com.tulane.leetcode.four;

/**
 * 动态规划
 * 最大正方形
 * Created by Tulane
 * 2019/11/25
 */
public class LeetCode_221 {

    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == '1') {
                    if(row == 0 || col == 0) dp[row][col] = 1;
                    else dp[row][col] = Math.min(Math.min(dp[row][col - 1], dp[row - 1][col]), dp[row - 1][col - 1]) + 1;
                    res = Math.max(res, dp[row][col]);
                }
            }
        }
        return res * res;
    }
}
