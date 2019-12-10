package com.tulane.leetcode.four;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tulane
 * 2019/12/10
 */
public class LeetCode_36 {

    public boolean isValidSudoku(char[][] board) {
        Set[] rows = new HashSet[9];
        Set[] cols = new HashSet[9];
        Set[] boxs = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet();
            cols[i] = new HashSet();
            boxs[i] = new HashSet();
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') continue;
                int box = row / 3 * 3 + col / 3;
                if (rows[row].contains(board[row][col])
                        || cols[col].contains(board[row][col])
                        || boxs[box].contains(board[row][col]))
                    return false;
                rows[row].add(board[row][col]);
                cols[col].add(board[row][col]);
                boxs[box].add(board[row][col]);
            }
        }
        return true;
    }
}
