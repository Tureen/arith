package com.tulane.leetcode.one;

/**
 * 不同路径II
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

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {
        int[] db = new int[obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) break;
            db[i] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    db[j] = 0;
                } else if (j != 0) {
                    db[j] += db[j - 1];
                }
            }
        }
        return db[db.length - 1];
    }
}
