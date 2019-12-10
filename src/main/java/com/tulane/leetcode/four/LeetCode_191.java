package com.tulane.leetcode.four;

/**
 * Created by Tulane
 * 2019/12/10
 */
public class LeetCode_191 {

    public int hammingWeight(int n) {
        int num = 0;
        while(n != 0){
            num++;
            n &= n - 1;
        }
        return num;
    }
}
