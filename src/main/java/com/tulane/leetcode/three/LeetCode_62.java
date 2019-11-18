package com.tulane.leetcode.three;

import java.util.Arrays;

/**
 * 不同路径
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_62 {

    public int uniquePaths(int m, int n) {
        int[] db = new int[n];
        Arrays.fill(db, 1);
        //db[0] = 1;//for循环中不会修改0坐标值, 相当于设置了所有左侧值为1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                db[j] += db[j - 1];
            }
        }
        return db[n - 1];
    }
}
