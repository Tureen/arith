package com.tulane.leetcode.four;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Tulane
 * 2019/12/10
 */
public class LeetCode_37 {

    public void solveSudoku(char[][] board) {
        Set[] rows = new HashSet[9];
        Set[] cols = new HashSet[9];
        Set[] boxs = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            boxs[i] = new HashSet();
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col] == '.') continue;
                int box = row / 3 * 3 + col / 3;
                rows[row].add(board[row][col]);
                cols[col].add(board[row][col]);
                boxs[box].add(board[row][col]);
            }
        }
        _solveSudoku(board, rows, cols, boxs, 0, new AtomicBoolean(false));
    }

    private void _solveSudoku(char[][] board, Set[] rows, Set[] cols, Set[] boxs, int num, AtomicBoolean atomicBoolean) {
        if (num >= 81) {
            atomicBoolean.set(true);
            return;
        }
        int row = num / 9, col = num % 9;
        if (board[row][col] != '.') {
            _solveSudoku(board, rows, cols, boxs, num + 1, atomicBoolean);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            char ch = (char) ('0' + i);
            int box = row / 3 * 3 + col / 3;
            if (rows[row].contains(ch) || cols[col].contains(ch) || boxs[box].contains(ch)) continue;
            rows[row].add(ch);
            cols[col].add(ch);
            boxs[box].add(ch);
            board[row][col] = ch;
            _solveSudoku(board, rows, cols, boxs, num + 1, atomicBoolean);
            if (!atomicBoolean.get()) {
                rows[row].remove(ch);
                cols[col].remove(ch);
                boxs[box].remove(ch);
                board[row][col] = '.';
            }
        }
    }
}
