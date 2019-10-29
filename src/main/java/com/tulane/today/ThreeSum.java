package com.tulane.today;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
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
 * Created by Tulane
 * 2019/10/20
 */
public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> list = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(list);
    }

    /**
     * 排序+循环双指针
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break;
            if (k > 0 && nums[k] == nums[k - 1]) continue;
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int target = nums[k] + nums[i] + nums[j];
                if (target < 0) {
                    while (i < j && nums[i] == nums[++i]) ;
                } else if (target > 0) {
                    while (i < j && nums[j] == nums[--j]) ;
                } else {
                    list.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[++i]) ;
                    while (i < j && nums[j] == nums[--j]) ;
                }
            }
        }
        return list;
    }
}
