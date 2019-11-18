package com.tulane.leetcode.one;

/**
 * 爬楼梯
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_70 {

    /**
     * 动态规划
     * DP方程: db[i] = db[i-1] + db[i-2]
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int[] db = new int[n+1];
        db[1] = 1;
        db[2] = 2;
        for (int i = 3; i <= n; i++) {
            db[i] = db[i-1] + db[i-2];
        }
        return db[n];
    }
}
