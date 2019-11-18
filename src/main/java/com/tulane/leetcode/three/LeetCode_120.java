package com.tulane.leetcode.three;

import java.util.List;

/**
 * 三角形最小路径和
 * Created by Tulane
 * 2019/11/18
 */
public class LeetCode_120 {

    /**
     * DP递推
     * <p>
     * 当前位置的最短路径, 由上一步的两种走法中最短的路径+自己本身得到
     * f[i,j] = min(f[i+1,j],f[i+1,j+1]) + a[i,j]
     * <p>
     * 自底向上遍历
     * 状态数组为一维 f[j]
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        //兼容最下行时的递推公式
        int[] dp = new int[triangle.get(triangle.size() - 1).size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
