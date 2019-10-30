package com.tulane.week;

/**
 * 移动零
 *
 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:

 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]
 说明:

 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。
 */


public class LeetCode_283 {

    /**
     * 从0下标开始遍历, 并将非零元素插入i下标, i下标右移
     * O(n)
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if(nums[j] == 0) continue;
            if(i != j){
                nums[i] = nums[j];
                nums[j] = 0;
            }
            i++;
        }
    }

    /**
     * O(n^2)
     * @param nums
     */
    public void moveZeroes1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) continue;
            int j = i;
            while(j < nums.length - 1 && nums[++j] == 0);
            nums[i] = nums[j];
            nums[j] = 0;
        }
    }
}
