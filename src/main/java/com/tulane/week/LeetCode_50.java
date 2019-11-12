package com.tulane.week;

/**
 * Created by Tulane
 * 2019/11/10
 */
public class LeetCode_50 {

    public static void main(String[] args) {
        System.out.println(new LeetCode_50().myPow(2, 4));
    }

    /**
     * 分治
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
        double a = _myPow(x, n/2 );
        return n%2 == 0 ? a*a : a*a*x;
    }
}
