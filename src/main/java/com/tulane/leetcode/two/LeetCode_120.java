package com.tulane.leetcode.two;

import java.util.List;

/**
 * 三角形最小路径和
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] db = new int[triangle.get(triangle.size() - 1).size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                db[j] = Math.min(db[j], db[j + 1]) + triangle.get(i).get(j);
            }
        }
        return db[0];
    }
}
