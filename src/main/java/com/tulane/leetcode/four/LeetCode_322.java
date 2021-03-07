package com.tulane.leetcode.four;

/**
 * 零钱兑换
 * Created by Tulane
 * 2019/11/28
 */
public class LeetCode_322 {

    public static void main(String[] args) {
        new LeetCode_322().coinChange(new int[]{2, 5}, 11);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int res = 0;
            for (int coin : coins) {
                if ((i - coin) == 0
                        || (i - coin) > 0 && dp[i - coin] != 0) {
                    dp[i] = dp[i - coin] + 1;
                    res = (res == 0 ? dp[i] : Math.min(res, dp[i]));
                }
            }
            dp[i] = res;
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
