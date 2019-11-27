package com.tulane.leetcode.four;

/**
 * 动态规划
 * 不同路径II
 * Created by Tulane
 * 2019/11/24
 */
public class LeetCode_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        dp[0] = 1;
        for (int[] rows : obstacleGrid) {
            for (int i = 0; i < rows.length; i++) {
                if (rows[i] == 1) {
                    dp[i] = 0;
                } else if (i > 0) {
                    dp[i] += dp[i - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i == 0 && j == 0) dp[j] = 1;
                    else if (i == 0) dp[j] = dp[j - 1];
                    else if (j == 0) dp[j] = dp[j];
                    else dp[j] = dp[j] + dp[j - 1];
                } else {
                    dp[j] = 0;
                }
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    if (i == 0 && j == 0) dp[i][j] = 1;
                    else if (i == 0) dp[i][j] = dp[i][j - 1];
                    else if (j == 0) dp[i][j] = dp[i - 1][j];
                    else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
