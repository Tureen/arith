package com.tulane.mine;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */

/**
 *
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2, -2147483648));
    }

    /**
     * 第二种 分治
     * 1. terminator
     * 2. process (split your bit problem)
     * 3. drill down (subproblem), merge(subsult)
     * 4. reverse status
     * <p>
     * x^n --> 2^10 = 2^5 * 2^5
     * 2^5 = 2^2* 2^2 * 2
     * <p>
     * pow(x, n):
     * subproblem: pow(x, n/2)
     * 时间复杂度 O(logn)
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return x < 0 ? -1 : 1;
        if (n < 0) {
            x = 1 / x;
        }
        double result = _myPow(x, n);
        return result;
    }

    private double _myPow(double x, int n) {
        if (n > 0 && n < 2 || n < 0 && n > -2) {
            return x;
        }
        // process , problem -> subproblem
        double result = _myPow(x, n / 2);

        // merge
        if (n % 2 == 0) {
            result = result * result;
        } else {
            result = result * result * x;
        }
        return result;
    }

    /**
     * 第一种 简单递归
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow1(double x, int n) {
        if (x == 0) return 0;
        double result = _myPow1(x, x, n, 0);
        if (x < 0 && result > 0) result = -result;
        return result;
    }

    private double _myPow1(double finalX, double x, int n, int i) {
        if (i >= n - 1) return finalX;
        double result = _myPow1(finalX * x, x, n, i + 1);
        return result;
    }
}
