package com.tulane.leetcode.one;

import java.util.Arrays;

/**
 * 打家劫舍II
 * Created by Tulane
 * 2019/11/23
 */
public class LeetCode_213 {

    public static void main(String[] args) {
        new LeetCode_213().rob(new int[]{1, 2, 3, 1});
    }

    /**
     * 斐波拉契数列 dp[i] = max(dp[i-1], dp[i-2]+num)
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(
                myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int myRob(int[] nums){
        int f1 = 0, f2 = 0, tmp;
        for (int num : nums) {
            tmp = f2;
            f2 = Math.max(f1 + num, f2);
            f1 = tmp;
        }
        return f2;
    }

    /**
     * 与打家劫舍I的递归公式一致, 区别在于收尾不能同时选
     * 所以存储两个相同状态数组, 第一个定义选择首部不选尾部(0 -> n-1), 第二个定位选择尾部不选首部(1 -> n)
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dpFir = new int[nums.length];
        int[] dpSec = new int[nums.length];
        dpFir[0] = nums[0];
        dpFir[1] = Math.max(dpFir[0], nums[1]);
        dpSec[1] = nums[1];
        dpSec[2] = Math.max(dpSec[1], nums[2]);
        for (int i = 2; i < nums.length; i++) {
            if (i < nums.length - 1) {
                dpFir[i] = Math.max(dpFir[i - 1], dpFir[i - 2] + nums[i]);
            }
            if (i >= 3) {
                dpSec[i] = Math.max(dpSec[i - 1], dpSec[i - 2] + nums[i]);
            }
        }
        return Math.max(dpFir[nums.length - 2], dpSec[nums.length -1]);
    }


    /**
     * DP递推
     *
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[][] dpFirst = new int[nums.length][2];
        int[][] dpLast = new int[nums.length][2];

        dpFirst[0][1] = nums[0];
        dpLast[1][1] = nums[1];
        for (int i = 1; i < nums.length; i++) {

            if (i < nums.length - 1) {
                dpFirst[i][0] = Math.max(dpFirst[i - 1][0], dpFirst[i - 1][1]);
                dpFirst[i][1] = dpFirst[i - 1][0] + nums[i];
            }
            if (i >= 2) {
                dpLast[i][0] = Math.max(dpLast[i - 1][0], dpLast[i - 1][1]);
                dpLast[i][1] = dpLast[i - 1][0] + nums[i];
            }
        }
        return Math.max(
                Math.max(dpFirst[nums.length - 2][0], dpFirst[nums.length - 2][1]),
                Math.max(dpLast[nums.length - 1][0], dpLast[nums.length - 1][1]));
    }
}
