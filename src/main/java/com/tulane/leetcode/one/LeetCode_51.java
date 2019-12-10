package com.tulane.leetcode.one;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * N皇后
 * Created by Tulane
 * 2019/11/27
 */
public class LeetCode_51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> totalList = new ArrayList<>();
        Set<Integer> pie = new HashSet<>();
        Set<Integer> na = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        _solveNQueens(totalList, new ArrayList<Integer>(), pie, na, cols, n, 0);

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

    private void _solveNQueens(List<List<Integer>> totalList, ArrayList<Integer> integers, Set<Integer> pie, Set<Integer> na, Set<Integer> cols, int n, int row) {
        // terminator
        if (row >= n) {
            totalList.add(new ArrayList<>(integers));
            return;
        }

        for (int col = 0; col < n; col++) {
            // process current logic
            if (!pie.contains(row + col) && !na.contains(row - col) && !cols.contains(col)) {
                integers.add(col);
                pie.add(row + col);
                na.add(row - col);
                cols.add(col);
                // drill down
                _solveNQueens(totalList, integers, pie, na, cols, n, row + 1);

                // clean status
                integers.remove(integers.size() - 1);
                pie.remove(row + col);
                na.remove(row - col);
                cols.remove(col);

            }
        }
    }
}
