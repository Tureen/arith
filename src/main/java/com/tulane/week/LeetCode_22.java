package com.tulane.week;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tulane
 * 2019/11/10
 */
public class LeetCode_22 {

    /**
     * 回溯 深度优先
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        dfs(list, n, 0, new StringBuilder(), 0, 0);
        return list;
    }

    private void dfs(List<String> list, int n, int i, StringBuilder strb, int left, int right) {
        if (i >= 2 * n) {
            list.add(strb.toString());
            return;
        }
        if (left < n) {
            dfs(list, n, i + 1, strb.append("("), left + 1, right);
            strb.deleteCharAt(strb.length() - 1);
        }
        if (right < left) {
            dfs(list, n, i + 1, strb.append(")"), left, right + 1);
            strb.deleteCharAt(strb.length() - 1);
        }
    }
}
