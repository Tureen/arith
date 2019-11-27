package com.tulane.leetcode.four;

/**
 * 数组双指针
 * 盛最多水的容器
 * Created by Tulane
 * 2019/11/24
 */
public class LeetCode_11 {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            res = Math.max(res, (j - i) * (height[i] > height[j] ? height[j--] : height[i++]));
        }
        return res;
    }
}
