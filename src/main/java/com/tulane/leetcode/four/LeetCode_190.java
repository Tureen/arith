package com.tulane.leetcode.four;

/**
 * Created by Tulane
 * 2019/12/10
 */
public class LeetCode_190 {

    public int reverseBits(int n) {
        int t = 0;
        for (int i = 0; i < 32; i++) {
            t = (t << 1) | (n & 1);
            n >>= 1;
        }
        return t;
    }
}
