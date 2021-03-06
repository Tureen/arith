package com.tulane.today;

/**
 *
 实现 pow(x, n) ，即计算 x 的 n 次幂函数。

 示例 1:

 输入: 2.00000, 10
 输出: 1024.00000
 示例 2:

 输入: 2.10000, 3
 输出: 9.26100
 示例 3:

 输入: 2.00000, -2
 输出: 0.25000
 解释: 2-2 = 1/22 = 1/4 = 0.25
 说明:

 -100.0 < x < 100.0
 n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2,4));
    }

    /**
     * 分治法 分多个结果并合并
     * x^n = x^(n/2) * x^(n/2)
     * 当n为奇数 *x
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return x < 0 ? -1 : 1;
        if (n < 0) x = 1 / x;
        return _myPow(x, n);
    }

    private double _myPow(double x, int n) {
        if (n > 0 && n < 2 || n < 0 && n > -2) return x;
        double result = _myPow(x, n/2);
        if(n % 2 == 0) return result * result;
        return result * result * x;
    }
}
