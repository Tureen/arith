package com.tulane.leetcode.two;

/**
 * 最大子序和
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_53 {

    public int maxSubArray(int[] nums) {
        int[] db = new int[nums.length];
        db[0] = nums[0];
        int res = db[0];
        for (int i = 1; i < nums.length; i++) {
            db[i] = Math.max(0, db[i - 1]) + nums[i];
            res = Math.max(res, db[i]);
        }
        return res;
    }
}
