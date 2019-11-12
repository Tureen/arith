package com.tulane.today;

/**
 * Created by Tulane
 * 2019/11/5
 */
public class CanJump {

    public boolean canJump(int[] nums) {
        if(nums.length == 0) return true;
        int end = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i] + i >= end) end = i;
        }
        if(end == 0) return true;
        return false;
    }
}
