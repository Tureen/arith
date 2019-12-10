package com.tulane.leetcode.two;

/**
 * Created by Tulane
 * 2019/12/1
 */
public class LeetCode_191 {

    public int hammingWeight(int n) {
        int i = 0;
        while (n != 0) {
            i++;
            n &= n - 1;
        }
        return i;
    }
}
