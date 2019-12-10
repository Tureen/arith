package com.tulane.leetcode.three;

/**
 * 2的幂
 * Created by Tulane
 * 2019/12/2
 */
public class LeetCode_231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
