package com.tulane.today;

import java.util.Stack;

/**
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。
 */
public class IsValid {

    /**
     * 操作栈
     * @param s
     * @return
     */
    public boolean isValid(String s) {

        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            if(c == '('){
                stack.push(')');
            }else if(c == '{'){
                stack.push('}');
            }else if(c == '['){
                stack.push(']');
            }else{
                if(stack.isEmpty()) return false;
                if(c != (char) stack.pop()) return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}
