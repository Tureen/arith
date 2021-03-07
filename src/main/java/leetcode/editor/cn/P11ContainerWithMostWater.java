//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2242 👎 0

package leetcode.editor.cn;
//java:盛最多水的容器
public class P11ContainerWithMostWater{
    public static void main(String[] args){
        Solution solution = new P11ContainerWithMostWater().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {
        // 先确定两边, 再不断缩进, 找到更高的高度, 与之前更宽宽度得到的面积做对比
        // 高度由最短的一边决定, 所以即使移动另一边也不会让高度增加
        if(height == null || height.length < 2){
            return 0;
        }
        int area = 0;
        for(int i = 0, j = height.length - 1; i < j;){
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            area = Math.max(area, minHeight * (j - i + 1));
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}