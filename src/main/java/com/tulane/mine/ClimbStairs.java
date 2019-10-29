package com.tulane.mine;//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划



//leetcode submit region begin(Prohibit modification and deletion)

//
/**
 * n阶楼梯, 1格 或 2格
 * 拆解思路:
 * 第一种, 暴力循环法 每一步都计算两种可能
 * 第二种, 分解法, 2格其实是1+1, n阶其实就是 1+1+..+1 = n, 然后算1+1+..+1的存放方式,
 *  相当于 1+ (1 + 1) + ...+ 1 包含(1+1)的称作簇, 一段公式中, 根据n大小计算簇能存在的最多个数,
 *  再从最多到0的簇数, 依次分析其出现的位置不同.
 * 第三种 斐波拉契数列 f(n) = f(n - 1) + f(n - 2)
 */

public class ClimbStairs {

    /**
     * 第三种
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int f1 = 1;
        int f2 = 2;
        int total = 3;
        if(n <= 3){
            return n;
        }
        for(int i = 3; i <= n; i++){
            total = f1 + f2;
            f1 = f2;
            f2 = total;
        }
        return total;
    }

    /**
     * TODO 第二种 分解簇, 根据n求出最大可以有多少个(1+1)簇
     * 死磕了很久发现数值还是不对, 等差数列那里计算错误, 先暂时放弃
     * 看视频讲题
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int totalWay = 0;
        int cu = n / 2;
        for(int i = cu; i > 0; i--){
            // 求出除簇以外的1的个数
            int aloneNum = n - i * 2;
            if(aloneNum == 0){
                continue;
            }
            // 变成了在指定长度的数组中, 可以放入多少种排列
            // 假定簇已经放入数组, 1的放入可看做插入的方式有多少
            /**
             *每个1的放入方式根据簇的所有空隙, 用等差数列和相关计算
             * 等差数列的项数为簇的数量加1, 差值为alone数量-1
             */
            int dcNum = i + 1;
            int dcSpace = aloneNum - 1;
            int dcMax = i * dcSpace + 1;
            float way = (dcMax + 1) * dcNum / 2;
            totalWay += way;
        }
        // 全部二格
        if(n%2==0){
            totalWay++;
        }
        // 全部一格
        totalWay++;
        return totalWay;
    }





    /**
     * 第一种 暴力循环其实可以看做, 将n分为一个二叉树, 每个子节点皆有两种可能性, 最终找到有多少最下级节点
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        recursionMain(n);
        return climbStairs1Int;
    }

    int climbStairs1Int = 0;

    private void recursionMain(int main){

        recursionLeft(main - 1);
        recursionRight(main - 2);
    }

    private void recursionLeft(int left){
        if(left <= 0){
            if(left == 0){
                climbStairs1Int++;
            }
            return;
        }
        recursionMain(left);
    }

    private void recursionRight(int right){
        if(right <= 0){
            if(right == 0){
                climbStairs1Int++;
            }
            return;
        }
        recursionMain(right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
