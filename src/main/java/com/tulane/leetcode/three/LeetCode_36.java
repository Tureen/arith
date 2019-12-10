package com.tulane.leetcode.three;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;

/**
 * 有效的数独
 * Created by Tulane
 * 2019/11/28
 */
public class LeetCode_36 {

    public static void main(String[] args) {
        String json = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
        new LeetCode_36().isValidSudoku(JSON.parseObject(json, char[][].class));
    }

    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxs = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxs[i] = new HashSet<>();
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(!addHashset(rows, cols, boxs, row, col, board)) return false;
            }
        }
        return true;
    }

    private boolean addHashset(Set<Character>[] rows, Set<Character>[] cols, Set<Character>[] boxs, int row, int col, char[][] board) {
        char ch = board[row][col];
        if(ch == '.') return true;
        int box = row / 3 * 3 + col / 3;
        if(rows[row].contains(ch) || cols[col].contains(ch) || boxs[box].contains(ch)) return false;
        rows[row].add(ch);
        cols[col].add(ch);
        boxs[box].add(ch);
        return true;
    }
}
