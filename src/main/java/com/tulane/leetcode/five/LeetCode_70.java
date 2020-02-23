package com.tulane.leetcode.five;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tulane
 * 2020/2/22
 */
public class LeetCode_70 {

    public int climbStairs2(int n) {
        if(n <= 2) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < dp.length; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    private static Map<Integer, Integer> memo = new HashMap<>();

    public int climbStairs(int n) {
        if(n - 1 == 0) return 1;
        else if(n - 2 == 0) return 2;
        else if(memo.containsKey(n)) return memo.get(n);

        memo.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        return memo.get(n);
    }
}
