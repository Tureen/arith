package com.tulane.leetcode.three;

/**
 * 不同路径II
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] db = new int[obstacleGrid[0].length];
        db[0] = 1;//兼容性设置, 兼容递归方程与判断是否有障碍物
        for (int[] rows : obstacleGrid) {
            for (int i = 0; i < rows.length; i++) {
                if (rows[i] == 1) {
                    db[i] = 0;
                } else if (i != 0) {
                    db[i] += db[i - 1];
                }
            }
        }
        return db[db.length - 1];
    }
}
