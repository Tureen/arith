package com.tulane.today;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 */

/**
 * TODO 是否可以精简
 */
public class MaxSlidingWindow {

    public static void main(String[] args) {
        new MaxSlidingWindow().maxSlidingWindow(new int[]{1, -1}, 1);
    }

    /**
     * 双端队列法
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length <= 0) return nums;
        Deque deque = new ArrayDeque();
        int[] arr = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty()) {
                deque.offerLast(i);
            }else {
                if ((int) deque.peekFirst() <= i - k) deque.pollFirst();
                while (!deque.isEmpty() && nums[i] > nums[(int) deque.peekLast()]) deque.pollLast();
                deque.offerLast(i);
            }
            if(i >= k - 1) arr[i - k + 1] = nums[(int)deque.peekFirst()];
        }
        return arr;
    }
}
