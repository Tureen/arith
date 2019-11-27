package com.tulane.leetcode.four;

/**
 * 动态规划
 * 最小路径和
 * Created by Tulane
 * 2019/11/25
 */
public class LeetCode_64 {

    public static void main(String[] args) {
        new LeetCode_64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}});
    }

    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (col == 0) dp[col] += grid[row][col];
                else if (row == 0) dp[col] = dp[col - 1] + grid[row][col];
                else dp[col] = Math.min(dp[col], dp[col - 1]) + grid[row][col];
            }
        }
        return dp[grid[0].length - 1];
    }

    public int minPathSum1(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (row == 0 && col == 0) dp[row][col] = grid[row][col];
                else if (col == 0) dp[row][col] = dp[row - 1][col] + grid[row][col];
                else if (row == 0) dp[row][col] = dp[row][col - 1] + grid[row][col];
                else dp[row][col] = Math.min(dp[row - 1][col], dp[row][col - 1]) + grid[row][col];
            }
        }
        return dp[grid.length - 1][grid[grid.length - 1].length - 1];
    }
}
