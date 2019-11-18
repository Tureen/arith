package com.tulane.leetcode.three;

/**
 * 最小路径和
 * Created by Tulane
 * 2019/11/18
 */
public class LeetCode_64 {

    /**
     * DP递推
     * <p>
     * 自上向下遍历
     * <p>
     * 当前节点的最小路径 = 左节点最小路径 与 上节点最小路径 的最小值 + 自身
     * <p>
     * DP方程: f[i,j] = min(f[i,j-1], f[i-1,j]) + a[i,j]
     * 状态数组为当前层数组
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) dp[j] = dp[j] + grid[i][j];
                else if (i == 0) dp[j] = dp[j - 1] + grid[i][j];
                else dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
            }
        }
        return dp[dp.length - 1];
    }
}
