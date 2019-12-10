package com.tulane.leetcode.one;

import com.alibaba.fastjson.JSON;

import java.util.HashSet;
import java.util.Set;

/**
 * 有效的数独
 * Created by Tulane
 * 2019/11/27
 */
public class LeetCode_36 {

//    public static void main(String[] args) {
//        String json = "[\n" +
//                "  [\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],\n" +
//                "  [\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],\n" +
//                "  [\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],\n" +
//                "  [\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],\n" +
//                "  [\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],\n" +
//                "  [\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],\n" +
//                "  [\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],\n" +
//                "  [\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],\n" +
//                "  [\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]\n" +
//                "]";
//
//        Character[][] characters = JSON.parseObject(json, Character[][].class);
//        new LeetCode_36().isValidSudoku(characters);
//    }

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
                if(board[row][col] == '.') continue;
                // 计算在哪个box中
                int box = (row / 3) * 3 + col / 3;
                // 判断是否存在
                if(rows[row].contains(board[row][col])
                        || cols[col].contains(board[row][col])
                        || boxs[box].contains(board[row][col])){
                    return false;
                }

                // 存入值
                rows[row].add(board[row][col]);
                cols[col].add(board[row][col]);
                boxs[box].add(board[row][col]);
            }
        }
        return true;
    }
}
