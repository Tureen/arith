package com.tulane.today;

/**
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

 说明：你不能倾斜容器，且 n 的值至少为 2。
 * Created by Tulane
 * 2019/10/20
 */
public class MaxArea {

    public static void main(String[] args) {
        System.out.println(new MaxArea().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    /**
     * 双指针 夹逼法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {

        int lastArea = 0;
        int i = 0, j = height.length - 1;
        while(i < j){
            lastArea = Math.max(lastArea, (j - i)* Math.min(height[i], height[j]));
            if(height[i] > height[j]){
                j--;
            }else{
                i++;
            }
        }
        return lastArea;
    }
}
