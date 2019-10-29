package com.tulane.binarysearch;


/**
 * Created by Tulane
 * 2019/10/13
 */
public class BaseBinarysearch {

    /**
     * title:
     * 假设有1000条订单数据, 已经按照订单金额从小到大排序, 每个订单金额都不同, 并且最小单位是元.
     * 我们现在想知道是否存在金额等于19元的订单. 如果存在则返回订单数据, 如果不存在则返回null.
     * <p>
     * solution:
     * 1. create 1000 size of array (order by num asc)
     * 2. binary search
     */
    public void exercise01(int length, int num) {

        /**
         * do step.1
         * create array
         */
        int[] intArr = new int[length];
        int i = (int) (Math.random() * 3);

        for (int x = 0; x < intArr.length; x++) {
            intArr[x] = i;
            i += (int) (Math.random() * 3) + 1;
        }

        /**
         * do step.2
         * binary
         */

        boolean flag = step2(num, length, intArr);
        boolean flag2 = step2Low(num, length, intArr);
        boolean flag3 = step2Teacher(num, length, intArr);

        System.out.println("flag: " + flag);
        System.out.println("flag2: " + flag2);
        System.out.println("flag3: " + flag3);
    }

    /**
     * O(logn)
     *
     * @param num
     * @param LENGTH
     * @param intArr
     * @return
     */
    private boolean step2(int num, int LENGTH, int[] intArr) {
        long startTime = System.currentTimeMillis();
        boolean flag = false;
        int startIndex = 0;
        int endIndex = LENGTH - 1;
        while (true) {

            if ((endIndex - startIndex) <= 1) {
                break;
            }

            int index = (startIndex + endIndex) / 2;

            if (num == intArr[index]) {
                flag = true;
                break;

            } else if (num < intArr[index]) {
                endIndex = index;

            } else if (num > intArr[index]) {
                startIndex = index;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("step2(quit) 耗时: " + (endTime - startTime));
        return flag;
    }

    /**
     * O(n)
     *
     * @param num
     * @param LENGTH
     * @param intArr
     * @return
     */
    private boolean step2Low(int num, int LENGTH, int[] intArr) {
        long startTime = System.currentTimeMillis();
        boolean flag = false;
        for (int i : intArr) {
            if (num == i) {
                flag = true;
                break;
            } else if (num < i) {
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("step2(low) 耗时: " + (endTime - startTime));
        return flag;
    }

    /**
     * O(n)
     * @param num
     * @param LENGTH
     * @param intArr
     * @return
     */
    private boolean step2Teacher(int num, int LENGTH, int[] intArr) {
        long startTime = System.currentTimeMillis();
        int low = 0;
        int high = LENGTH - 1;
        boolean flag = false;

        while (true) {

            if (low > high) {
                break;
            }

            int mid = low + ((high - low) >> 1);

            if(num == intArr[mid]){
                flag = true;
                break;
            }else if(num < intArr[mid]){
                high = mid - 1;
            }else if(num > intArr[mid]){
                low = mid + 1;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("step2(teacher) 耗时: " + (endTime - startTime));
        return flag;
    }

    public static void main(String[] args) {
        new BaseBinarysearch().exercise01(100000000, 501230342);
    }
}
