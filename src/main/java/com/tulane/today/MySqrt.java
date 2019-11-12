package com.tulane.today;

/**
 * Created by Tulane
 * 2019/11/5
 */
//!TODO 需要去国际站看看
public class MySqrt {

    public int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        double left = 0, right = x;
        while(left <= right){
            double mid = left + (right - left) / 2;
            if(mid*mid <= x && (mid+1)*(mid+1) > x) return (int)mid;
            else if(mid*mid < x) left = mid + 1;
            else right = mid - 1;
        }
        return 0;
    }
}
