package com.tulane.leetcode.four;

import java.util.Arrays;

/**
 * 打家劫舍II
 * Created by Tulane
 * 2019/12/1
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

    private int myRob(int[] nums){
        int pre = 0, cur = 0, tmp;
        for (int num : nums) {
            tmp = cur;
            cur = Math.max(cur, pre + num);
            pre = tmp;
        }
        return cur;
    }

    public int rob1(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[] dpStart = new int[nums.length];
        int[] dpEnd = new int[nums.length];
        dpStart[0] = nums[0];
        dpStart[1] = Math.max(dpStart[0], nums[1]);
        dpEnd[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if(i != nums.length - 1) {
                dpStart[i] = Math.max(dpStart[i - 1], dpStart[i - 2] + nums[i]);
            }
            dpEnd[i] = Math.max(dpEnd[i - 1], dpEnd[i - 2] + nums[i]);
        }
        return Math.max(dpStart[nums.length - 2], dpEnd[nums.length - 1]);
    }
}
