package com.tulane.today;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 */
public class SolveNQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> totalList = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pies = new HashSet<>();
        Set<Integer> nas = new HashSet<>();
        _solveNQueens(totalList, n, 0, cols, pies, nas, new ArrayList<>());
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

    private void _solveNQueens(List<List<Integer>> totalList, int n, int row, Set<Integer> cols, Set<Integer> pies, Set<Integer> nas, List<Integer> list) {
        if(row >= n) {
            totalList.add(new ArrayList<>(list));
            return;
        }
        int col = -1;
        while(++col < n) {
            if (!cols.contains(col) && !pies.contains(row + col) && !nas.contains(row - col)){
                cols.add(col);
                pies.add(row + col);
                nas.add(row - col);
                list.add(col);
                _solveNQueens(totalList, n, row + 1, cols, pies, nas, list);

                cols.remove(col);
                pies.remove(row + col);
                nas.remove(row - col);
                list.remove(list.size() - 1);
            }
        }
    }

}
