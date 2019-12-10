package com.tulane.leetcode.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tulane
 * 2019/12/10
 */
public class LeetCode_151 {

    public String reverseWords(String s) {
        String[] arr = s.trim().split(" ");
        List<String> list = new ArrayList<>();
        for (String str : arr) {
            if (str != null && !"".equals(str.trim())) {
                list.add(str);
            }
        }
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
