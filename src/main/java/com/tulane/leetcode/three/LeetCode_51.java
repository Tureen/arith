package com.tulane.leetcode.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N皇后
 * Created by Tulane
 * 2019/11/28
 */
public class LeetCode_51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> totalList = new ArrayList<>();
        Set<Integer> pies = new HashSet<>();
        Set<Integer> nas = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        _solveNQueens(totalList, new ArrayList<Integer>(), pies, nas, cols, n, 0);

        List<List<String>> strList = new ArrayList<>();
        for (List<Integer> list : totalList) {
            List<String> strs = new ArrayList<>();
            for (Integer integer : list) {
                String str = "";
                for (int i = 0; i < n; i++) {
                    if (i == integer) {
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

    private void _solveNQueens(List<List<Integer>> totalList, ArrayList<Integer> integers, Set<Integer> pies, Set<Integer> nas, Set<Integer> cols, int n, int row) {
        if (row >= n) {
            totalList.add(new ArrayList<>(integers));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pies.contains(row + col) || nas.contains(row - col)) continue;
            integers.add(col);
            cols.add(col);
            pies.add(row + col);
            nas.add(row - col);

            _solveNQueens(totalList, integers, pies, nas, cols, n, row + 1);

            integers.remove(integers.size() - 1);
            cols.remove(col);
            pies.remove(row + col);
            nas.remove(row - col);
        }
    }
}
