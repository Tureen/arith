package com.tulane.mine;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 * <p>
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 */

import com.alibaba.fastjson.JSON;

/**
 * 思考:
 * 1. 首先想到的是指针法, 将指针置于数组末端, 循环右移k此, 遇到数组尾则重置为0, 最终从指针所在位置遍历数组, 时间复杂度O(n)级 (根据K值)
 * 2. 直接挪动数组, 末尾放入临时变量, 并整体右移, 将临时变量置入0下标, 时间复杂度O(n^2)
 * 3. 直接计算法, K值除以数组长度的余数即是坐标0最终被移动到的位置
 * 4. 在计算法时, 每次向后推的办法需要移动一个元素多次, 可以跨步移动, 而跨步移动的元素, 将要覆盖的元素未确定, 可以使用递归假设后面的节点已完成交换
 */
public class Rotate {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        new Rotate().rotate(arr, 5);
        System.out.println(JSON.toJSON(arr));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int i = 0;
        int tmp = nums[i + k];
        nums[i + k] = nums[i];

    }

    /**
     * TODO 无法解决环后乱跳问题
     * 第一种 双指针交换+递归
     * 1 -> 3
     * 2 -> 4
     * 3 -> 5
     * 4 -> 6
     * 5 -> 7
     * 6 -> 8
     * 7 -> 0
     * 8 -> 1
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int i = 0;
        k = k % nums.length;
        int j = k;
        while(j-- > 0) {
            int swap = recursion(nums, i, k);
            nums[i] = swap;
            i++;
            System.out.println(swap);
        }
    }

    private int recursion(int[] nums, int i, int stepNum) {
        if (i + stepNum > nums.length - 1)  return nums[i];
        int swap = recursion(nums, i + stepNum, stepNum);
        nums[i + stepNum] = nums[i];
        return swap;
    }

//    int i = 0, j = nums.length - k % nums.length;
//        while(j < nums.length) {
//        int tmp = nums[i];
//        nums[i++] = nums[j];
//        nums[j++] = tmp;
//    }
}
