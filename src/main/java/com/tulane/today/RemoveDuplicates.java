package com.tulane.today;

/**
 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{}));
    }

    /**
     * TODO 感觉条件可以再优化
     * 快慢指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0;
        while(nums.length > 0 && i <= j && (i == 0 || nums[i] > nums[i - 1])){
            while(true){
                if(j >= nums.length - 1){
                    return i + 1;
                }
                if(nums[++j] > nums[i]){
                    break;
                }
            }
            nums[++i] = nums[j];
        }
        return i;
    }
}
