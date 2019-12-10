package com.tulane.leetcode.three;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词接龙
 * Created by Tulane
 * 2019/12/1
 */
public class LeetCode_127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginWordSet = new HashSet<>();
        Set<String> endWordSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        if(!wordSet.contains(endWord)) return 0;
        beginWordSet.add(beginWord);
        endWordSet.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);
        int level = 0;
        while(!beginWordSet.isEmpty() && !endWordSet.isEmpty()){
            level++;
            if(beginWordSet.size() > endWordSet.size()){
                Set<String> tmp = beginWordSet;
                beginWordSet = endWordSet;
                endWordSet = tmp;
            }
            Set<String> beginWordTmpSet = new HashSet<>();
            for (String oldWord : beginWordSet) {
                for (String newWord : wordSet) {
                    if(!validateChange(newWord, oldWord)) continue;
                    if(endWordSet.contains(newWord)) return level + 1;
                    if(visited.contains(newWord)) continue;
                    visited.add(newWord);
                    beginWordTmpSet.add(newWord);
                }
            }
            beginWordSet = beginWordTmpSet;
        }
        return 0;
    }

    private boolean validateChange(String newWord, String oldWord) {
        int index = 0;
        for (int i = 0; i < newWord.length(); i++) {
            if(newWord.charAt(i) != oldWord.charAt(i)){
                if(++index > 1) return false;
            }
        }
        return true;
    }
}
