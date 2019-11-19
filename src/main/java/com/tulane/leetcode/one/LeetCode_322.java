package com.tulane.leetcode.one;

import java.util.Arrays;

/**
 * 零钱兑换
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_322 {

    public static void main(String[] args) {
        new LeetCode_322().coinChange(new int[]{4}, 4);
    }

    /**
     * 动态规划
     * <p>
     * DP
     * a. subproblems
     * b. DP array: f(n) = min{ f(n-k)), for k in [1,2,5] } + 1
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if ((i - coin == 0) || ((i - coin > 0) && dp[i - coin] > 0)) {
                    // 缓存当前位置的最少硬币值, 之后会被替换的值比对并保留最小
                    int min = dp[i] == 0 ? Integer.MAX_VALUE : dp[i];
                    dp[i] = dp[i - coin] + 1;
                    dp[i] = Math.min(min, dp[i]);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public int coinChange1(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin == 0)
                    dp[i] = 1;
                else if (i - coin > 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    int min = dp[i];
                    dp[i] = Math.min(min, dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 :dp[amount];
    }
}
