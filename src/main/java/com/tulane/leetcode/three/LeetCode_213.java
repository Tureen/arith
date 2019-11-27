package com.tulane.leetcode.three;

import java.util.Arrays;

/**
 * Created by Tulane
 * 2019/11/24
 */
public class LeetCode_213 {

    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(
                myRob(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                myRob(Arrays.copyOfRange(nums, 1, nums.length))
        );
    }

    private int myRob(int[] nums) {
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(pre + num, cur);
            pre = tmp;
        }
        return cur;
    }

    public int rob1(int[] nums) {
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
            if (i > 2) {
                dpSec[i] = Math.max(dpSec[i - 1], dpSec[i - 2] + nums[i]);
            }
        }
        return Math.max(dpFir[nums.length - 2], dpSec[nums.length - 1]);
    }
}
