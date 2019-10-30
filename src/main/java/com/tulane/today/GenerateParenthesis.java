package com.tulane.today;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

 例如，给出 n = 3，生成结果为：

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(JSON.toJSON(new GenerateParenthesis().generateParenthesis(0)));
    }

    /**
     * 回溯法 给n格子放括号 递归所有可能
     * 判断是否有效
     * 1. 当加入的是左括号时, 可以随便加, 至到超过n个
     * 2. 当加入的是右括号时, 必须小于等于左括号数
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if(n == 0) return list;
        _generateParenthesis(list, n, 0, 0, 0, "");
        return list;
    }

    private void _generateParenthesis(List<String> list, int n, int i, int left, int right, String str) {
        if(i >= 2*n){
            list.add(str);
            return;
        }
        if(left < n) _generateParenthesis(list, n, i + 1, left + 1, right, str + "(");
        if(right < left) _generateParenthesis(list, n, i + 1, left, right + 1, str + ")");
    }
}
