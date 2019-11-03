package com.tulane.homework;

/**
 * Created by Tulane
 * 2019/11/3
 */
public class Test {

    public static void main(String[] args) {
        new Test().binarySearch(new int[]{4,0});
    }

//    使用二分查找，寻找一个半有序数组 [4, 5, 6, 7, 0, 1, 2] 中间无序的地方

    /**
     * 二分缩进时是重点, 不能采用有序时的直接比较大小
     * 推导:
     * => 由于是半有序数组
     * => 前半部分有序数组的值都大于后半部分
     * => 当二分取值大于左边界值, 说明mid在左半边有序部分, 需缩进左坐标
     * => 当取值小与左边界值, 说明mid在右半边有序部分, 需缩进右坐标
     * @param arr
     * @return
     */
    public int binarySearch(int[] arr){
        int left = 0, right = arr.length;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(arr[mid] < arr[mid + 1] && arr[mid] < arr[mid - 1]) return mid;
            else if (arr[mid] > arr[left]) left = mid;
            else right = mid;
        }
        return 0;
    }
}
