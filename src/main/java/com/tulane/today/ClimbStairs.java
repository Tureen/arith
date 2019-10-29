package com.tulane.today;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

 注意：给定 n 是一个正整数。
 * Created by Tulane
 * 2019/10/20
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(
                new ClimbStairs().climbStairs(5)
        );
    }

    /**
     * 斐波拉契数列
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        int f1 = 1;
        int f2 = 2;
        int total = 3;
        if(n <= 2){
            return n;
        }
        for(int i = 3; i <= n; i++){
            total = f1 + f2;
            f1 = f2;
            f2 = total;
        }
        return total;
    }
}
