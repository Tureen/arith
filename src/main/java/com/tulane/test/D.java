package com.tulane.test;

import java.util.ArrayList;
import java.util.List;

public class D {
    /**
     * 第一种 递归
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
            totalList.add(list);
            return;
        }
        _subsets(totalList, nums, i+1, new ArrayList<>(list));
        list.add(nums[i]);
        _subsets(totalList, nums, i+1, list);

    }

    public static void main(String[] args) {
        D u = new D();
        List<List<Integer>> list = u.subsets(new int[]{1,2,3});
        for(List<Integer> li1 : list){
            for(Integer li2 : li1){
                System.out.print(li2);
            }
            System.out.println();
        }
    }

}
