package com.tulane.leetcode.three;

/**
 * Created by Tulane
 * 2019/12/10
 */
public class LeetCode_122 {

    public int maxProfit1(int[] prices) {
        if (prices.length == 0) return 0;
        int[][][] dp = new int[prices.length][2][2];
        for (int i = 0; i < prices.length; i++) {
            if (i - 1 == -1) {
                dp[i][1][0] = 0;
                dp[i][1][1] = -prices[i];
                continue;
            }
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i]);
        }
        return dp[prices.length - 1][1][0];
    }

    public int maxProfit(int[] prices) {
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - price);
        }
        return dp_i_0;
    }
}
