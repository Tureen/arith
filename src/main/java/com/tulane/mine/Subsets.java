package com.tulane.mine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

 说明：解集不能包含重复的子集。

 示例:

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

/**
 * 思路:
 *
 * 1. 假设有nums.length长的格子, 每个里可装对应nums[i]元素, 也可以不装, 递归所有情况
 *
 * 2. 动态规划, 每次向[[]]中加入一个元素, 先遍历已有的子集, 将元素加到每个子集的后面产生新的子集
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
    }

    /**
     * 第二种 递归 list传导时的变化
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> totalList = new ArrayList<>();
        _subsets(totalList, nums, 0, new ArrayList<>());
        return totalList;
    }

    private void _subsets(List<List<Integer>> totalList, int[] nums, int i, List<Integer> list) {
        if(i >= nums.length) {
            totalList.add(new ArrayList<>(list));
            return;
        }
        _subsets(totalList, nums, i+1, list);
        list.add(nums[i]);
        _subsets(totalList, nums, i+1, list);
        list.remove(list.size() - 1);
    }

    /**
     * 第一种 递归
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> totalList = new ArrayList<>();
        _subsets1(totalList, nums, 0, new ArrayList<>());
        return totalList;
    }

    private void _subsets1(List<List<Integer>> totalList, int[] nums, int i, List<Integer> list) {
        if(i >= nums.length) {
            totalList.add(list);
            return;
        }
        _subsets1(totalList, nums, i+1, new ArrayList<>(list));
        list.add(nums[i]);
        _subsets1(totalList, nums, i+1, list);

    }
}
