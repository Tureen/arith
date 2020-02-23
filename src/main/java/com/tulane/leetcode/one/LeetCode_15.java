package com.tulane.leetcode.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Tulane
 * 2019/12/12
 */
public class LeetCode_15 {

    public static void main(String[] args) {
        new LeetCode_15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        for(int i = 0; i < nums.length - 2; i++){ // 需要j,k的位置, i不会在最后两个坐标中
            if(nums[i] > 0) break;
            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum < 0){
                    while(j < k && nums[j] == nums[++j]);
                }else if(sum > 0){
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
