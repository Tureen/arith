package com.tulane.leetcode.one;

/**
 * 移动零
 * Created by Tulane
 * 2019/11/19
 */
public class LeetCode_283 {

    /**
     * 双指针重建顺序数组的思想,
     * i, j 0下标处
     * j下标从0遍历数据, 遇到非零数放到i下标位置, 同时i移动1
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] != 0){
                if(i != j) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
        }
    }
}
