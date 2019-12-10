package com.tulane.leetcode.three;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tulane
 * 2019/12/10
 */
public class LeetCode_387 {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
