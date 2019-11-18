package com.tulane.leetcode.three;

/**
 * 最长公共子序列
 * Created by Tulane
 * 2019/11/18
 */
public class LeetCode_1143 {

    public static void main(String[] args) {
        new LeetCode_1143().longestCommonSubsequence("bsbininm", "jmjkbkjkv");
    }

    /**
     * DP递推
     * <p>
     * |    a  b  c  d  e |
     * <p>
     * | a  1  1  1  1  1 |
     * <p>
     * | c  1  1  2  2  2 |
     * <p>
     * | e  1  1  2  2  3 |
     * <p>
     * 将字符串转为二维数组
     * 则f[i,j]的值为 f[i,j-1]与f[i-1,j] 的最大值, 再看自身位置f[i,j]比较后是否相等, 相等则加一
     * <p>
     * a. 重复性: 比较上两步, 去最大值, 如果当前位末尾值相同, 则加一
     * b. 状态数组: f[i,j]
     * c. 递推公式: f[i,j] = Max( f[i,j-1], f[i-1,j] ) + f[i,j] is equals
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] db = new int[s1.length + 1][s2.length + 1];
        for (int i = 1; i < s1.length + 1; i++) {
            for (int j = 1; j < s2.length + 1; j++) {
                if (s1[i - 1] == s2[j - 1])
                    db[i][j] = db[i - 1][j - 1] + 1;
                else
                    db[i][j] = Math.max(db[i][j - 1], db[i - 1][j]);
            }
        }
        return db[s1.length][s2.length];
    }
}
