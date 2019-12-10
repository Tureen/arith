package com.tulane.leetcode.two;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by Tulane
 * 2019/11/28
 */
public class LeetCode_37 {

    public void solveSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxs = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>((int) (9 / 0.75 + 1));
            cols[i] = new HashSet<>((int) (9 / 0.75 + 1));
            boxs[i] = new HashSet<>((int) (9 / 0.75 + 1));
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                int box = row / 3 * 3 + col / 3;
                if(board[row][col] != '.') {
                    rows[row].add(board[row][col]);
                    cols[col].add(board[row][col]);
                    boxs[box].add(board[row][col]);
                }
            }
        }
        _solveSudoku(board, 0, 0, rows, cols, boxs, new AtomicBoolean(false));
    }

    private void _solveSudoku(char[][] board, int row, int col, Set<Character>[] rows, Set<Character>[] cols, Set<Character>[] boxs, AtomicBoolean atomicBoolean) {
        if (col > 8) {
            col = 0;
            row++;
            if (row > 8) {
                atomicBoolean.set(true); // 清除状态标记
                return;
            }
        }
        char nowBoard = board[row][col];
        if (nowBoard != '.') {
            _solveSudoku(board, row, col + 1, rows, cols, boxs, atomicBoolean);
            return;
        }

        int box = row / 3 * 3 + col / 3;
        for (int i = 1; i <= 9; i++) {
            nowBoard = (char) (i + '0');
            if (rows[row].contains(nowBoard) || cols[col].contains(nowBoard) || boxs[box].contains(nowBoard)) continue;
            board[row][col] = nowBoard;
            rows[row].add(nowBoard);
            cols[col].add(nowBoard);
            boxs[box].add(nowBoard);

            _solveSudoku(board, row, col + 1, rows, cols, boxs, atomicBoolean);

            if (!atomicBoolean.get()) {
                board[row][col] = '.';
                rows[row].remove(nowBoard);
                cols[col].remove(nowBoard);
                boxs[box].remove(nowBoard);
            }
        }
    }
}
