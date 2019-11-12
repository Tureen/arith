package com.tulane.week;

import java.util.*;

/**
 *
 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class LeetCode_17 {

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

    private void _letterCombinations(List<String> list, Map<Character, List<String>> map, char[] numbers, int number, StringBuilder stringBuilder) {
        if(number >= numbers.length){
            list.add(stringBuilder.toString());
            return;
        }
        for (String s : map.get(numbers[number])) {
            stringBuilder.append(s);
            _letterCombinations(list, map, numbers, number + 1, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}
