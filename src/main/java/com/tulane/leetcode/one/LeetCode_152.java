package com.tulane.leetcode.one;

/**
 * 乘积最大子序列
 * Created by Tulane
 * 2019/11/19
 */
public class LeetCode_152 {

    /**
     * DP
     * <p>
     * 当前节点的最大值由 上一步最大或最小值与当前节点的乘积前后中最大的值确定
     * 当前节点的最小值由 上一步最大或最小值与当前节点的乘积前后中最大的值确定
     * <p>
     * 何时取上个节点的最大值或最小值, 由当前节点是否负数决定
     * <p>
     * DP方程: f[i] = Math.max(f[i-1] * a[i], a[i])
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        // 记录当前元素的正向最大数与反向最大数
        int res = nums[0], min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = max;
                max = min;
                min = tmp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
