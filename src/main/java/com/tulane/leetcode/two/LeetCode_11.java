package com.tulane.leetcode.two;

/**
 * Created by Tulane
 * 2019/11/16
 */
public class LeetCode_11 {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = Math.max(res, ((j - i) * (height[i] > height[j] ? height[j--] : height[i++])));
        }
        return res;
    }
}
