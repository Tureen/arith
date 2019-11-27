package com.tulane.leetcode.three;

/**
 * 零钱兑换
 * Created by Tulane
 * 2019/11/21
 */
public class LeetCode_322 {

    /**
     * DP递推
     * <p>
     * dp[i] = min(dp[i-k]...) + 1
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin == 0) {
                    dp[i] = 1;
                } else if ((i - coin > 0) && dp[i - coin] != 0) {
                    int tmp = dp[i - coin] + 1;
                    dp[i] = dp[i] == 0 ? tmp : Math.min(tmp, dp[i]);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }
}
