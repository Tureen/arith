package com.tulane.test;

import java.util.*;

/**
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class C {

    // 遍历并将值存入hash表
    // target-nums[0] = nums[1]
    public int[] twoSum(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                list.add(i);
            }else{
                set.add(target - nums[i]);
            }
        }
//        return list.toArray();
        return null;
    }
}
