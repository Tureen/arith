package com.tulane.leetcode.two;

/**
 * 最大正方形
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_221 {

    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int[][] db = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) db[i][j] = 1;
                    else db[i][j] = Math.min(Math.min(db[i - 1][j], db[i][j - 1]), db[i - 1][j - 1]) + 1;
                    res = Math.max(res, db[i][j]);
                }
            }
        }
        return res*res;
    }
}
