package com.tulane.leetcode.five;

import sun.applet.Main;

public class LeetCode_322 {

    public int coinChange(int[] coins, int amount){
        int[] dp = new int[amount + 1];
        for(int i = 1; i <= amount; i++){
            int res = 0;

            for(int coin : coins){
                if((i - coin) == 0){
                    res = 1;
                    break;
                }
                if((i - coin) > 0 && dp[i - coin] != 0){
                    dp[i] = dp[i - coin] + 1;
                    res =  (res == 0 ? dp[i] : Math.min(res, dp[i]));
                }
            }
            dp[i] = res;
        }
        return 1;
    }
}
