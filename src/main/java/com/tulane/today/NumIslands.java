package com.tulane.today;

import java.util.HashSet;
import java.util.Set;

/**
 *
 输入:
 11110
 11010
 11000
 00000

 * Created by Tulane
 * 2019/11/6
 */
public class NumIslands {

    /**
     * 深度优先遍历
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int num = 0;
        if(grid == null || grid.length <= 0) return num;
        boolean[][] market = new boolean[grid.length][grid[0].length];
        int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1' && !market[i][j]){
                    num++;
                    dfs(grid, i, j, market, dx, dy);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] market, int[] dx, int[] dy) {
        if(market[row][col]) return;
        market[row][col] = true;
        for (int x = 0; x < dx.length; x++) {
            int newRow = row + dx[x], newCol = col + dy[x];
            if(newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[row].length || grid[newRow][newCol] != '1') continue;
            dfs(grid, newRow, newCol, market, dx, dy);
        }
    }
}
