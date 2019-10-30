package com.tulane.today;

import java.util.ArrayList;
import java.util.List;

/**
 输入: nums = [1,2,3]
 输出:
 [
 [3],
   [1],
   [2],
   [1,2,3],
   [1,3],
   [2,3],
   [1,2],
   []
 ]

 */
public class Subsets {

    /**
     * 回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> totalList = new ArrayList<>();
        _subsets(totalList, new ArrayList<>(), nums, 0);
        return totalList;
    }

    private void _subsets(List<List<Integer>> totalList, ArrayList<Integer> list, int[] nums, int i) {
        if(i >= nums.length){
            totalList.add(new ArrayList<>(list));
            return;
        }
        _subsets(totalList, list, nums, i + 1);
        list.add(nums[i]);
        _subsets(totalList, list, nums, i + 1);
        list.remove(list.size() - 1);
    }
}
