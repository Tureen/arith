package com.tulane.leetcode.four;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tulane
 * 2019/12/10
 */
public class LeetCode_51 {

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> total = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pies = new HashSet<>();
        Set<Integer> nas = new HashSet<>();
        _solveNQueens(total, new ArrayList<Integer>(), cols, pies, nas, 0, n);

        List<List<String>> strList = new ArrayList<>();
        for (List<Integer> list : total) {
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

    private void _solveNQueens(List<List<Integer>> list, ArrayList<Integer> integers, Set<Integer> cols, Set<Integer> pies, Set<Integer> nas, int row, int n) {
        if (row >= n) {
            list.add(new ArrayList<>(integers));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || pies.contains(row - col) || nas.contains(row + col)) continue;
            cols.add(col);
            pies.add(row - col);
            nas.add(row + col);
            integers.add(col);
            _solveNQueens(list, integers, cols, pies, nas, row + 1, n);
            cols.remove(col);
            pies.remove(row - col);
            nas.remove(row + col);
            integers.remove(integers.size() - 1);
        }
    }
}
