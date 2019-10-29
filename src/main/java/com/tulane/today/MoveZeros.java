package com.tulane.today;

import com.alibaba.fastjson.JSON;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * Created by Tulane
 * 2019/10/20
 */
public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 0, 0, 5};
        new MoveZeros().moveZeroes(nums);
        System.out.println(JSON.toJSON(nums));
    }

    // [0, 1, 3, 0, 0, 5]

    /**
     * 双指针
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            if(nums[j] == 0){
                continue;
            }
            if(i != j) {
                nums[i] = nums[j];
                nums[j] = 0;
            }
            //每次不为0, 指针都需移动
            i++;
        }
    }
}
