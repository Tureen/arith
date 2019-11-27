package com.tulane.leetcode.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 爬楼梯
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_70 {

    public static void main(String[] args) {
        new LeetCode_70().climbStairs(4);
    }



    public int climbStairs(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return _climbStairs(n, 0, memo);
    }

    private int _climbStairs(int n, int hight, Map<Integer, Integer> memo) {
        if (hight > n) return 0;
        else if(hight == n) return 1;
        else if(memo.containsKey(hight)) return memo.get(hight);
        memo.put(hight, _climbStairs(n, hight + 1, memo) + _climbStairs(n, hight + 2, memo));
        return memo.get(hight);
    }

    /**
     * 动态规划
     * DP方程: db[i] = db[i-1] + db[i-2]
     *
     * @param n
     * @return
     */
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
