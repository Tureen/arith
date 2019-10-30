package com.tulane.week;

/**
 * 滑动窗口最大值
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

 返回滑动窗口中的最大值。

  

 示例:

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
  

 提示：

 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

  

 进阶：

 你能在线性时间复杂度内解决此题吗？
 */

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 思路: 后加入的数, 在入队后挤掉之前小于它的
 */
public class LeetCode_239 {

    /**
     * 双端队列法
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k == 0) return new int[]{};
        Deque deque = new ArrayDeque();
        int[] arr = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            //撞针: 保留顺序最大队列
            while(!deque.isEmpty() && nums[(int) deque.peekLast()] <= nums[i]) deque.pollLast();
            //过期淘汰: 离开滑动窗口
            if(!deque.isEmpty() && (int)deque.peekFirst() <= (i - k)) deque.pollFirst();
            deque.offerLast(i);
            if(i >= k - 1) arr[i - k + 1] = nums[(int) deque.peekFirst()];
        }
        return arr;
    }
}
