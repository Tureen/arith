package com.tulane.leetcode.two;

/**
 * Created by Tulane
 * 2019/11/16
 */
public class LeetCode_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] db = new int[obstacleGrid[0].length];
        db[0] = 1;
        for (int[] rows : obstacleGrid) {
            for (int i = 0; i < rows.length; i++) {
                if (rows[i] == 1) {
                    db[i] = 0;
                } else if (i != 0) {
                    db[i] += db[i - 1];
                }
            }
        }
        return db[obstacleGrid[0].length - 1];
    }
}
