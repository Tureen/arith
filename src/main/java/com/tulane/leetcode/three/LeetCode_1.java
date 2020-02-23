package com.tulane.leetcode.three;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tulane
 * 2019/12/15
 */
public class LeetCode_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
