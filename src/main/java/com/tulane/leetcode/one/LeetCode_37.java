package com.tulane.leetcode.one;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by Tulane
 * 2019/11/27
 */
public class LeetCode_37 {

    public static void main(String[] args) {
        String json = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
        new LeetCode_37().solveSudoku(JSON.parseObject(json, char[][].class));
    }

    public void solveSudoku(char[][] board) {
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
                if (board[row][col] == '.') continue;
                int box = (row / 3) * 3 + col / 3;
                rows[row].add(board[row][col]);
                cols[col].add(board[row][col]);
                boxs[box].add(board[row][col]);
            }
        }
        _solveSudoku(board, 0, 0, rows, cols, boxs, new AtomicReference<>(false));
    }

    private void _solveSudoku(char[][] board, int row, int col, Set<Character>[] rows, Set<Character>[] cols, Set<Character>[] boxs, AtomicReference<Boolean> flag) {
        if (row > 8 || col > 8) {
            flag.set(true);
            return;
        }

        char nowBoard = board[row][col];

        if (nowBoard != '.') {
            if (col >= 8) _solveSudoku(board, row + 1, 0, rows, cols, boxs, flag);
            else _solveSudoku(board, row, col + 1, rows, cols, boxs, flag);
            return;
        }
        int box = row / 3 * 3 + col / 3;

        for (int i = 1; i <= 9; i++) {
            nowBoard = (char) (i + '0');
            if (rows[row].contains(nowBoard) || cols[col].contains(nowBoard) || boxs[box].contains(nowBoard)) continue;

            rows[row].add(nowBoard);
            cols[col].add(nowBoard);
            boxs[box].add(nowBoard);

            board[row][col] = nowBoard;
            if (col >= 8) _solveSudoku(board, row + 1, 0, rows, cols, boxs, flag);
            else _solveSudoku(board, row, col + 1, rows, cols, boxs, flag);

            if(!flag.get()) {
                board[row][col] = '.';
                rows[row].remove(nowBoard);
                cols[col].remove(nowBoard);
                boxs[box].remove(nowBoard);
            }
        }

    }

}
