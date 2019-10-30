package com.tulane.week;

/**
 * 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */

import java.util.Stack;

/**
 * 栈 抵消法
 */
public class LeetCode_20 {

    public boolean isValid(String s) {
        Stack stack = new Stack();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '(') stack.push(')');
            if (aChar == '[') stack.push(']');
            if (aChar == '{') stack.push('}');
            if (aChar == ')' && (stack.isEmpty() || (char) stack.pop() != aChar)) return false;
            if (aChar == ']' && (stack.isEmpty() || (char) stack.pop() != aChar)) return false;
            if (aChar == '}' && (stack.isEmpty() || (char) stack.pop() != aChar)) return false;
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
