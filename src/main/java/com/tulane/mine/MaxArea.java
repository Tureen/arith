package com.tulane.mine;

public class MaxArea {

    /**
     * 第五种 老师的写法, 比第二种的写法优美
     * @param height
     * @return
     */
    public int maxArea(int[] height){
        int maxArea = 0;
        for(int i = 0, j = height.length - 1; i < j; ){
            int minHeight = height[i] > height[j] ? height[j--] : height[i++];
            //由于之前i与j距离减少1, 在计算本次值时需加回1
            int area = (j - i + 1) * minHeight;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    /**
     * 第四种 仍是基于第二种优化, 第三种优化不彻底, 只比对上一步的值
     * 应该记录在移动过程中, x指针与y指针分别出现过的最大高度, 依此判断
     *
     * @param height
     * @return
     */
    public int maxArea4(int[] height) {
        int x = 0, y = height.length - 1;
        int maxArea = 0;
        int maxHeightX = height[x];
        int maxHeightY = height[y];

        boolean arithFlag = true;

        for (; ; ) {
            //终止条件
            if (x == y) {
                break;
            }

            int heightX = height[x];
            int heightY = height[y];

            if (arithFlag) {
                arithFlag = false;
                int area = (y - x) * Math.min(heightX, heightY);
                maxArea = Math.max(maxArea, area);

            }

            //选择指针移动
            if (heightX > heightY) {
                y--;
                heightY = height[y];
                if (heightY > maxHeightY) {
                    maxHeightY = heightY;
                    arithFlag = true;
                }
            } else {
                x++;
                heightX = height[x];
                if (heightX > maxHeightX) {
                    maxHeightX = heightX;
                    arithFlag = true;
                }
            }
        }
        return maxArea;
    }


    /**
     * 第三种 第二种是否可以再优化,
     * 当知道下一步的高度并不比前一步的高时, 可以不进行比对直接跳过
     *
     * @param height
     * @return
     */
    public int maxArea3(int[] height) {
        int x = 0, y = height.length - 1;
        int maxArea = 0;
        int flag = -1;
        for (; ; ) {
            //终止条件
            if (x == y) {
                break;
            }

            //判断是否需要比对最大面积
            if (!((flag == x && (height[x - 1] > height[x]))
                    || (flag == y && (height[y + 1] > height[y])))) {
                //计算面积
                int area = (y - x) * Math.min(height[x], height[y]);
                maxArea = Math.max(maxArea, area);
            }

            //选择指针移动
            if (height[x] > height[y]) {
                y--;
                flag = y;
            } else {
                x++;
                flag = x;
            }
        }
        return maxArea;
    }

    /**
     * 第二种 创建双指针x, y分别指向头部与尾部, 依次向内移动, 出现"选择性移动问题"
     * 由于每次移动的步长相同, 并且根据面积公式length*height, 步长相等的情况下,
     * 影响面积大小的值为height, 所以, 选择头指针移动还是尾指针移动时, 根据两者height值判断
     *
     * @param height
     * @return
     */
    public int maxArea2(int[] height) {
        int x = 0, y = height.length - 1;
        int maxArea = 0;
        for (; ; ) {
            //终止条件
            if (x == y) {
                break;
            }
            //计算面积
            int area = (y - x) * Math.min(height[x], height[y]);
            maxArea = Math.max(maxArea, area);
            //选择指针移动
            if (height[x] > height[y]) {
                y--;
            } else {
                x++;
            }
        }
        return maxArea;
    }

    /**
     * 第一种 穷举所有 O(n^2)
     * 计算面积, (y - x) * Math.min(heightX, heightY)
     */
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int x = 0; x < height.length; x++) {
            for (int y = x + 1; y < height.length; y++) {
                int area = (y - x) * Math.min(height[x], height[y]);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}