package com.tulane.week;

/**
 * 爬楼梯
 */
public class LeetCode_70 {

    public int climbStairs(int n) {
        if(n <= 2) return n;
        int ppre = 1;
        int pre = 2;
        int x = 3;
        while(x <= n){
            int clim = ppre + pre;
            ppre = pre;
            pre = clim;
            x++;
        }
        return pre;
    }
}
