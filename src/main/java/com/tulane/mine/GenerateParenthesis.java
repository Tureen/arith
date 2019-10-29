package com.tulane.mine;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 *
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

/**
 * 思路:
 * 1. 用栈的进出方式得到, n对则代表有n个数要进入栈, 出栈的方法有多少种 (这种有可能是傻递归, 要算出所有可能)
 *
 * 2. 试用数学归纳法
 *  1: ()
 *  2: ()() (())
 *  3: ()()() (())() ()(()) ((())) (()())
 *
 *  1: (
 *  2: (( ()
 *  3: ((( (() ()( ())
 *
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        List<String> list = new GenerateParenthesis().generateParenthesis(3);
        System.out.println(JSON.toJSON(list));
    }

    /**
     * 第一种,递归法
     * 条件
     * 1. n对括号, 则左括号与右括号最终都为n
     * 2. 左括号添加时, 可随意添加, 只要不大于n
     * 3. 右括号添加时, 需要不大于当前添加的左括号数
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        _generate(list, 0, 0, n, "");
        return list;
    }

    private void _generate(List<String> list, int left, int right, int n, String str) {
        // terminator 终结者
        if(left == n && right == n ){
            list.add(str);
            return;
        }

        // process current logic
        if(left < n){
            // drill down
            _generate(list, left + 1 , right, n, str + "(");
        }
        if(right < left){
            // drill down
            _generate(list, left, right + 1, n, str + ")");
        }
    }

}
