package com.tulane.leetcode.two;

/**
 * 移动零
 * Created by Tulane
 * 2019/11/19
 */
public class LeetCode_283 {

    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != 0){
                if(i != j){
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
        }
    }
}
