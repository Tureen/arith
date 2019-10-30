package com.tulane.week;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */

/**
 * a + b = -c
 */
public class LeetCode_15 {

    public static void main(String[] args) {
        new LeetCode_15().threeSum(new int[]{-1,0,1,2,-1,-4});
    }

    /**
     * 排序+双指针  O(nlogn) +
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if(nums[i] > 0) break;
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < 0) {
                    while(j < k && nums[j] == nums[++j]);
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    while(j < k && nums[k] == nums[--k]);
                }else{
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(j < k && nums[j] == nums[++j]);
                    while(j < k && nums[k] == nums[--k]);
                }
            }
        }
        return list;
    }
}
