package com.tulane.leetcode.two;

/**
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_70 {

    public int climbStairs(int n) {
        if (n < 3) return n;
        int f1 = 1, f2 = 2, f3 = f1 + f2;
        for (int i = 3; i <= n; i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }

    public int climbStairs1(int n) {
        if (n == 1) return 1;
        int[] db = new int[n + 1];
        db[1] = 1;
        db[2] = 2;
        for (int i = 3; i <= n; i++) {
            db[i] = db[i - 1] + db[i - 2];
        }
        return db[n];
    }
}
