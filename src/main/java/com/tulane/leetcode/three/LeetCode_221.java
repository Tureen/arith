package com.tulane.leetcode.three;

/**
 * 最大正方形
 * Created by Tulane
 * 2019/11/18
 */
public class LeetCode_221 {

    /**
     * DP递推
     * <p>
     * 如果该点为1, 该点的最大正方形边长, 由前三步的最小边长决定, 并将结果加1
     * 如果该点为0, 则该点最大边长为0
     * f[i,j] = min(f[i-1,j-1], f[i-1,j], f[i,j-1]) + 1
     * 状态数组: f[i,j]
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res*res;
    }
}
