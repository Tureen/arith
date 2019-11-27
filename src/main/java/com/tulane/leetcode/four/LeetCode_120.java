package com.tulane.leetcode.four;

import java.util.List;

/**
 * 动态规划
 * 三角形最小路径和
 * Created by Tulane
 * 2019/11/25
 */
public class LeetCode_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size() - 1).size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
