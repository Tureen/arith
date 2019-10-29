package com.tulane.mine;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 * <p>
 * <p>
 * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
 */

import java.util.Stack;

/**
 * 思考:
 * 1. 类似盛最多水的容器 双指针夹逼法 <- 不适用, 面积不由两端决定, 不能夹逼缩进
 * 2. 暴力法, 双指针, 从0开始, 双重遍历, 计算所有面积
 * 3. 求每个下标柱子的最大面积, 利用相邻的特性, 使用自身高度左右扩展, 得到以自身高度为基数的矩形
 */
public class LargestRectangleArea {

    public static void main(String[] args) {
        System.out.println(new LargestRectangleArea().largestRectangleArea(new int[]{5,4,1,2}));
    }

    /**
     * 第四种 操作栈
     * 特性一: 栈内元素始终保持递增的形势, 当有小于栈顶元素的元素入栈时, 需要弹出所有大于它的元素
     * 特性二: 柱状图的每个元素所能拥有的最大面积是其高度乘以能扩展的最大宽度, 最大宽度是该元素向两边扩展, 遇到小于其值时停止扩展
     *
     * 根据特性一与特性二得到两个结论:
     *  1. 当元素入栈时, 如果比栈顶元素大不弹出其他栈, 此时的元素最宽左边界即是自身下标, 也是栈顶元素下标+1
     *  2. 当元素入栈时, 如果比栈顶元素小, 会弹出所有大于它的栈, 此时的元素最宽左边界便是其弹出的最后一个元素的下标, 也是弹出操作后, 栈顶元素的下标+1
     *  3. 当元素出栈时, 由于是被比自身小的元素弹出栈, 所以其右边界也已确定, 即为当前要入栈元素的下标-1
     *
     * 我们可以利用1、2结论, 统一计算一个元素入栈后, 其左边界即已经确定, 并且为相邻栈(上一个栈)元素的下标+1
     * 再利用结论3, 得知在元素出栈时, 其左右边界即已确定, 可计算此元素的面积
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack stack = new Stack();

        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            while(true){
                if(stack.isEmpty() || heights[i] >= heights[(int) stack.peek()] ){
                    stack.push(i);
                    break;
                }else{
                    int out = (int) stack.pop();
                    int top = -1;
                    if(!stack.isEmpty()) top = (int) stack.peek();
                    int area = heights[out] * (i - top - 1); // (i - 1 - (top + 1) + 1)
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        while(heights.length > 0 && !stack.isEmpty()){
            int out = (int) stack.pop();
            int top = -1;
            if(!stack.isEmpty()) top = (int) stack.peek();
            int area = heights[out] * (heights.length - top - 1); // (height - 1 - (top + 1) + 1)
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    /**
     * TODO 计算左边界时的想法错误, 已重写另一个
     * 第四种 操作栈
     * 从下标0开始, 将元素入栈, 当元素大于栈顶元素时, 可以入栈, 并存入下标值
     * 此时, 栈内存储的便是一个个高度的元素的左边界, 边界点为自身下标值
     * 当元素小于栈顶元素时, 弹出栈顶, 此时弹出的栈元素的右边界, 即为当前将要入栈元素的下标值减一
     * 由此以自身为高度(最低点)确定两个边界, 计算出该元素的最大面积
     * @param heights
     * @return
     */
    public int largestRectangleAreaTmp(int[] heights) {

        int maxArea = 0;
        Stack stack = new Stack();
        for (int i = 0; i < heights.length; i++) {
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            while(true){
                if(stack.isEmpty() || heights[i] >= heights[(int) stack.peek()] ){
                    // 1.若元素空了, 直接入栈
                    // 2.元素比栈顶元素大, 可确认左边界为自身坐标, 入栈
                    stack.push(i);
                    break;
                }else{
                    //元素比栈顶元素小, 可确认栈顶元素右边界, 出栈并计算
                    int top = (int) stack.pop();
                    int area = heights[top] * (i - top);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        while(heights.length > 0){
            //此时的栈内元素为递增, 都是右边界不确定的
            //除了栈底元素, 其他元素的左边界都已确定为自身
            //栈底元素能存在到最后, 说明是整个数组中最小的, 特殊处理面积即可
            int top = (int) stack.pop();
            if(stack.isEmpty()){
                //此处处理最小的栈底元素
                maxArea = Math.max(maxArea, heights[top] * (heights.length));
                break;
            }
            maxArea = Math.max(maxArea, heights[top] * (heights.length - top));
        }
        return maxArea;
    }

    /**
     * 第三种 得到每个下标值的面积, 以自身为高度
     * @param heights
     * @return
     */
    public int largestRectangleArea3(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i, right = i;
            while (true) {
                if (right >= heights.length - 1) {
                    right++;
                    break;
                }
                if (heights[++right] < heights[i]) break;
            }
            while (true) {
                if (left <= 0) {
                    left--;
                    break;
                }
                if (heights[--left] < heights[i]) break;
            }
            int width = (i - left - 1) + (right - i - 1) + 1;
            maxArea = Math.max(maxArea, width * heights[i]);
        }
        return maxArea;
    }

//    while(right <= heights.length - 1 && heights[right++] >= heights[i]);
//            while(left >= 0 && heights[left--] >= heights[i]);

//    while(true){
//        if(right >= heights.length - 1) right++;
//        if(heights[++right] < heights[i]) break;
//    }
//            while(true){
//        if(left <= 0) left--;
//        if(heights[--left] < heights[i]) break;
//    }

    /**
     * TODO 此方法错误 不可取: 不类似于水的问题, 因为面积的计算不由两端决定, 而由中间最小值决定, 所以在夹逼缩减中, 不能根据两端高来比较, 夹逼法不适用
     * 第一种 双指针夹逼法
     * !!!注 最高高度由两个指针中间所有值中最短的决定
     * 还需计算每个柱子的高度
     * @param heights
     * @return
     */
    public int largestRectangleArea1(int[] heights) {
        int i = 0, j = heights.length - 1;
        int maxArea = 0;
        while (i < j) {
            int area = (j - i + 1) * min(heights, i, j);
            maxArea = Math.max(maxArea, area);
            if (heights[i] > heights[j]) {
                j--;
            } else {
                i++;
            }
        }
        for (int height : heights) {
            maxArea = Math.max(maxArea, height);
        }
        return maxArea;
    }

    private int min(int[] heights, int i, int j) {
        int minheight = Integer.MAX_VALUE;
        while (i <= j) {
            minheight = Math.min(heights[i++], minheight);
        }
        return minheight;
    }
}
