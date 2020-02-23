package com.tulane.leetcode.one;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tulane
 * 2019/12/12
 */
public class LeetCode_1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) return new int[]{map.get(nums[i]), i};
            map.put(target - nums[i], i);
        }
        return null;
    }
}
