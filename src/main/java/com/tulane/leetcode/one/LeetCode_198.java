package com.tulane.leetcode.one;

/**
 * 打家劫舍
 * Created by Tulane
 * 2019/11/21
 */
public class LeetCode_198 {

    public static void main(String[] args) {
        new LeetCode_198().rob(new int[]{1,2});
    }


    /**
     * 定义状态数组为, dp[i]表示当前节点必填时的最大值
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length];
    }

    /**
     * DP递推
     * <p>
     * 子问题
     * 状态数组
     * 递推公式
     * <p>
     * a[i][1|0] 当前节点的必选, 和不选状态
     * a[i][0] = Max(a[i-1][0], a[i-1][1])
     * a[i][1] = a[i-1][0] + nums[i]
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    /**
     * !!! 错误的方式
     * <p>
     * 简单型, 除2取余的所有累加数对比
     *
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        int simpleNum = 0, douleNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i % 2 == 0) douleNum += nums[i];
            else simpleNum += nums[i];
        }
        return Math.max(simpleNum, douleNum);
    }
}
