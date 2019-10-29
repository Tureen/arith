package com.tulane.mine;

/**
 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

 返回滑动窗口中的最大值。

 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 输出: [3,3,5,5,6,7]
 解释:

 滑动窗口的位置                最大值
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


 */

import com.alibaba.fastjson.JSON;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 思路:
 * 1. 暴力法 使用双指针, 移动并返回最大值
 *
 * 2. 老师的讲解 用队列法
 * -> 加入的元素会撞击队列中比其小的元素, 使队列的排序最终呈现从大到小, 则每次滑动窗口的最大值即是最左的值
 * -> 当队列中的值呈现6, 3 时 这时加入进来5,不仅要尝试撞队头, 也要撞击队尾, 所以选用双端队列, 先后都可出队
 */

/**
 * TODO 给自己布置的作业: ArrayDeque与LinkedList比较, 在这里谁最适用
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] arr = new MaxSlidingWindow().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
        System.out.println(JSON.toJSON(arr));
    }

    /**
     * 第三种 优化双端队列, 在撞队列时只需要撞击队尾即可, 即可保证队列的从大到小顺序
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length<= 0) return new int[]{};
        int[] arr = new int[nums.length - k + 1];
        ArrayDeque deque = new ArrayDeque();
        for (int i = 0; i < nums.length; i++) {
            //出队判断
            if(!deque.isEmpty() && (int)deque.peekFirst() <= i - k) deque.pollFirst();
            //撞击
            while(!deque.isEmpty() && nums[i] >= nums[(int)deque.peekLast()]) deque.pollLast();
            deque.offerLast(i);
            if(i >= k - 1) arr[i - k + 1] = nums[(int) deque.peekFirst()];
        }
        return arr;
    }

    /**
     * 第二种 双端队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length<= 0) return new int[]{};
        int[] arr = new int[nums.length - k + 1];
        Deque deque = new LinkedList();

        for (int i = 0; i < nums.length; i++) {
            //出队判断
            if(!deque.isEmpty() && (int)deque.peekFirst() <= i - k) deque.pollFirst();
            //撞击
            while(!deque.isEmpty()){
                if(nums[i] >= nums[(int)deque.peekFirst()]){
                    deque.pollFirst();
                }else if(nums[i] >= nums[(int)deque.peekLast()]){
                    deque.pollLast();
                }else{
                    break;
                }
            }
            deque.offerLast(i);
            if(i >= k - 1) arr[i - k + 1] = nums[(int) deque.peekFirst()];
        }
        return arr;
    }

    /**
     * !!! 错误, 滑动时的固定大小未考虑, 队头数有可能已经出队, 思路是改为存储下标, 重写
     * 第二种 双端队列法
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2Tmp(int[] nums, int k) {
        if (nums.length<= 0) return new int[]{};
        int[] arr = new int[nums.length - k + 1];
        Deque deque = new LinkedList();

        for (int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty()){
                if(nums[i] >= (int)deque.peekFirst()){
                    deque.pollFirst();
                }else if(nums[i] >= (int)deque.peekLast()){
                    deque.pollLast();
                }else{
                    break;
                }
            }
            deque.offerLast(nums[i]);
            if(deque.size() > k) deque.pollFirst();
            if(i >= k - 1) arr[i - k + 1] = (int) deque.peekFirst();
        }
        return arr;
    }

    /**
     * 第一种 暴力法
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length<= 0) return new int[]{};
        int[] arr = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length - k + 1; i++) {
            int j = i + k - 1;
            int max = maxInArr(nums, i, j);
            arr[i] = max;
        }
        return arr;
    }

    private int maxInArr(int[] nums, int i, int j) {
        int max = Integer.MIN_VALUE;
        do max = Math.max(nums[i], max);
        while(++i <= j);
        return max;
    }
}
