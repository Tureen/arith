package com.tulane.leetcode.two;

/**
 * 乘积最大子序列
 * Created by Tulane
 * 2019/11/19
 */
public class LeetCode_152 {

    public int maxProduct(int[] nums) {
        int res = nums[0], min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            res = Math.max(res, max);
        }
        return res;
    }
}
