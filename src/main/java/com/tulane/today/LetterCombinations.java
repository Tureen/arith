package com.tulane.today;

/**
 * 电话号码的字母组合
 *
 *
 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。



 示例:

 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 说明:
 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。

 */

import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * 给定n个格子
 * 回溯法, 递归出n个格子的每种数字及对应字母
 */
public class LetterCombinations {

    public static void main(String[] args) {
        new LetterCombinations().letterCombinations("23");
    }

    /**
     * 回溯法
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits == null || "".equals(digits.trim())) return list;
        char[] numbers = digits.toCharArray();
        Map<Character, List<String>> map = new HashMap<>();
        map.put('1', Arrays.asList("*"));
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));

        _letterCombinations(list, map, numbers, 0, new StringBuilder());
        return list;
    }

    private void _letterCombinations(List<String> list, Map<Character, List<String>> map, char[] numbers, int i, StringBuilder strb) {
        // terminator
        if(i >= numbers.length) {
            list.add(strb.toString());
            return;
        }

        // process
        List<String> strings = map.get(numbers[i]);
        for (String str : strings) {
            strb.append(str);
            // drill status
            _letterCombinations(list, map, numbers, i + 1, strb);

            // reverse status
            strb.deleteCharAt(strb.length() - 1);
        }
    }
}
