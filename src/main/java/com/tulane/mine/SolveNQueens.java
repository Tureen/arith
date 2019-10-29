package com.tulane.mine;

/**
 *
 *
 n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

 上图为 8 皇后问题的一种解法。

 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

 示例:

 输入: 4
 输出: [
 [".Q..",  // 解法 1
 "...Q",
 "Q...",
 "..Q."],

 ["..Q.",  // 解法 2
 "Q...",
 "...Q",
 ".Q.."]
 ]
 解释: 4 皇后问题存在两个不同的解法。
 */

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 思路: 回溯法 遍历所有可能, 错误的则清除状态
 */
public class SolveNQueens {

    public static void main(String[] args) {
        System.out.println(JSON.toJSON(new SolveNQueens().solveNQueens(4)));
    }

    /**
     * 第一种 回溯
     * 重点 判断方法
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {

        List<List<Integer>> totalList = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pies = new HashSet<>();
        Set<Integer> nas = new HashSet<>();
        _solveNQueens(totalList, new ArrayList<>(), n, 0, cols, pies, nas);

        List<List<String>> strList = new ArrayList<>();
        for (List<Integer> list : totalList) {
            List<String> strs = new ArrayList<>();
            for (Integer integer : list) {
                String str = "";
                for(int i = 0; i < n; i++){
                    if(i == integer){
                        str += "Q";
                        continue;
                    }
                    str += ".";
                }
                strs.add(str);
            }
            strList.add(strs);
        }
        return strList;
    }

    private void _solveNQueens(List<List<Integer>> totalList, List<Integer> list, int n, int row, Set<Integer> cols, Set<Integer> pies, Set<Integer> nas) {
        //terminator
        if(row > n - 1){
            totalList.add(new ArrayList<>(list));
            return;
        }

        // process current logic
        for(int col = 0; col < n; col++){
            if (!cols.contains(col) && !pies.contains(row + col) && !nas.contains(row - col)){
                cols.add(col);
                pies.add(row + col);
                nas.add(row - col);
                list.add(col);

                // drill down
                _solveNQueens(totalList, list, n, row + 1, cols, pies, nas);

                //reset status
                cols.remove(col);
                pies.remove(row + col);
                nas.remove(row - col);
                list.remove(list.size() - 1);
            }
        }
    }

}