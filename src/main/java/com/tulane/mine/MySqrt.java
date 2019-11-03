package com.tulane.mine;

/**
 *
 实现 int sqrt(int x) 函数。

 计算并返回 x 的平方根，其中 x 是非负整数。

 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

 示例 1:

 输入: 4
 输出: 2
 示例 2:

 输入: 8
 输出: 2
 说明: 8 的平方根是 2.82842...,
      由于返回类型是整数，小数部分将被舍去。
 */

/**
 * 思考: 根据x, 从1到x, 依次平方查看是否为该数,
 * 直接遍历时间复杂度O(n)
 * 由于从开始遍历并平方的值, 是递增, 所以使用二分法 O(logn)
 */
public class MySqrt {

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(17));
    }

    /**
     * 二分法
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        double left = 1, right = x;
        while(left <= right){
            double mid = (int)(left + (right - left) / 2);
            if(mid*mid <= x && (mid + 1)*(mid + 1) > x) return (int)mid;
            else if(mid*mid < x) left = mid + 1;
            else right = mid - 1;
        }
        return 0;
    }
}
