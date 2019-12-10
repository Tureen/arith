package com.tulane.leetcode.three;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * TODO
 * 解数独
 * Created by Tulane
 * 2019/11/29
 */
public class LeetCode_37 {

    public void solveSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxs = new HashSet[9];
        char[] chars = new char[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            boxs[i] = new HashSet();
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') continue;
                int box = row / 3 * 3 + col / 3;
                rows[row].add(board[row][col]);
                cols[col].add(board[row][col]);
                boxs[box].add(board[row][col]);
            }
        }
        _solveSudoku(board, rows, cols, boxs, 0, 0, new AtomicBoolean(false));
    }

    private void _solveSudoku(char[][] board, Set<Character>[] rows, Set<Character>[] cols, Set<Character>[] boxs, int row, int col, AtomicBoolean atomicBoolean) {
        if (col > 8) {
            row++;
            col = 0;
            if (row > 8) {
                atomicBoolean.set(true);
                return;
            }
        }
        if (board[row][col] != '.') {
            _solveSudoku(board, rows, cols, boxs, row, col + 1, atomicBoolean);
            return;
        }
        int box = row / 3 * 3 + col / 3;
        for (int i = 1; i <= 9; i++) {
            char ch = (char) (i + '0');
            if (rows[row].contains(ch) || cols[col].contains(ch) || boxs[box].contains(ch)) continue;
            rows[row].add(ch);
            cols[col].add(ch);
            boxs[box].add(ch);
            board[row][col] = ch;

            _solveSudoku(board, rows, cols, boxs, row, col + 1, atomicBoolean);

            if (!atomicBoolean.get()) {
                rows[row].remove(ch);
                cols[col].remove(ch);
                boxs[box].remove(ch);
                board[row][col] = '.';
            }
        }
    }

}
