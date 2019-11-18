package com.tulane.leetcode.two;

/**
 * 最小路径和
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_64 {

    public int minPathSum(int[][] grid) {
        int[] db = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (j == 0) db[j] += grid[i][j];
                else if (i == 0) db[j] = db[j - 1] + grid[i][j];
                else db[j] = Math.min(db[j], db[j - 1]) + grid[i][j];
            }
        }
        return db[db.length - 1];
    }
}
