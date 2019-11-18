package com.tulane.leetcode.one;

/**
 * 最大子序和
 * Created by Tulane
 * 2019/11/17
 */
public class LeetCode_53 {

    /**
     * a.子问题: max_sum(i) = Max(max_sum(i-1), 0)
     * b.状态数组定义: f[i]
     * c.DP方程: f[i] = Max(f[i-1], 0) + a[i]
     * <p>
     * 最大子序和 = 当前元素自身最大, 或者包含之后最大
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] db = new int[nums.length];
        db[0] = nums[0];
        int res = db[0];
        for (int i = 1; i < nums.length; i++) {
            db[i] = Math.max(db[i - 1], 0) + nums[i];
            res = Math.max(res, db[i]);
        }
        return res;
    }
}
