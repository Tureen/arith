package com.tulane.leetcode.two;

/**
 * Created by Tulane
 * 2019/12/8
 */
public class LeetCode_121 {

    public int maxProfit(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, -price);
        }
        return dp_i_0;
    }
}
