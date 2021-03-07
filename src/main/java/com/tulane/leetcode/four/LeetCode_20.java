package com.tulane.leetcode.four;

import java.util.Stack;

public class LeetCode_20 {

    public boolean isValid(String s) {
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || (c != (char) stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
