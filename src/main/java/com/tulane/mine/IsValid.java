package com.tulane.mine;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

 有效字符串需满足：

 左括号必须用相同类型的右括号闭合。
 左括号必须以正确的顺序闭合。
 注意空字符串可被认为是有效字符串。
 */

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * 思考:
 * 1. 定义一个缓存变量, 用来记录左括号的最后值
 * 2. 第1点的仅定义一个变量, 但变量会因左括号被抵消而变换为前一个左括号, 所以应该用栈存储一组左括号
 */
public class IsValid {

    public static void main(String[] args) {
        System.out.println(new IsValid().isValid("([)()"));
    }

    /**
     * 第二种, 网上方法, 精简化第一种
     * @param s
     * @return
     */
    public boolean isValid(String s){
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else{
                if(stack.isEmpty() || (char)stack.pop() != c){
                    return false;
                }
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }

    /**
     * 第一种, 遍历时将所有左括号入栈, 当遇到右括号时, 出栈比对, 成功则继续失败则返回false
     * 附: 当循环完毕后, 若栈不为空, 说明仍有左括号未配对, 返回false
     * @param s
     * @return
     */
    public boolean isValid1(String s) {
        Stack stack = new Stack();
        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            if(c[i] == '(' || c[i] == '{' || c[i] == '['){
                //左括号全部入栈
                stack.push(c[i]);
            }else{
                //右括号, 比对
                char left = 0;
                try {
                    left = (char) stack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
                if(left == '(' && c[i] != ')'){
                    return false;
                }else if(left == '{' && c[i] != '}'){
                    return false;
                }else if(left == '[' && c[i] != ']'){
                    return false;
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }
}
