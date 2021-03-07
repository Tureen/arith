package com.tulane.test;

public class H {

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if ((i - coin == 0) || ((i - coin > 0) && dp[i - coin] > 0)) {
                    int min = dp[i] == 0 ? Integer.MAX_VALUE : dp[i];
                    dp[i] = dp[i - coin] + 1;
                    dp[i] = Math.min(min, dp[i]);
                }
            }
        }
        return dp[amount] == 0 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        coinChange(new int[]{1, 2, 5}, 11);
    }
}
