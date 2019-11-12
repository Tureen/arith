package com.tulane.week;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Tulane
 * 2019/11/10
 */
public class LeetCode_51 {

    public List<List<String>> solveNQueens(int n) {

        List<List<Integer>> totalList = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pies = new HashSet<>();
        Set<Integer> nas = new HashSet<>();
        _solveNQueens(totalList, n, 0, cols, pies, nas, new ArrayList<>());
    }

    private void _solveNQueens(List<List<Integer>> totalList, int n, int i, Set<Integer> cols, Set<Integer> pies, Set<Integer> nas, ArrayList<Integer> list) {
//        for (int col = 0; col < n; col++) {
//            if()
//        }
    }
}
