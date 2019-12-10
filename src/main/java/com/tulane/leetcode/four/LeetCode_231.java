package com.tulane.leetcode.four;

/**
 * Created by Tulane
 * 2019/12/10
 */
public class LeetCode_231 {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
