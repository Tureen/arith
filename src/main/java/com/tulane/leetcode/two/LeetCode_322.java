package com.tulane.leetcode.two;

/**
 * 零钱兑换
 * Created by Tulane
 * 2019/11/19
 */
public class LeetCode_322 {

    public static void main(String[] args) {
        new LeetCode_322().coinChange(new int[]{1, 2, 5}, 11);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin == 0)
                    dp[i] = 1;
                else if ((i - coin > 0) && dp[i - coin] != 0) {
                    int tmp = dp[i - coin] + 1;
                    dp[i] = (dp[i] == 0 ? tmp : Math.min(tmp, dp[i]));
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
