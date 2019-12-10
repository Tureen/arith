package com.tulane.leetcode.two;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 单词接龙
 * Created by Tulane
 * 2019/11/30
 */
public class LeetCode_127 {

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        new LeetCode_127().ladderLength("hit", "cog", wordList);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        if (!wordSet.contains(endWord)) return 0;
        beginSet.add(beginWord);
        endSet.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);
        int level = 0;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            level++;
            if(beginSet.size() > endSet.size()){
                Set<String> tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }
            Set<String> beginSetTmp = new HashSet<>((int)(beginSet.size() / 0.75 + 1));
            for (String begin : beginSet) {
                for (String word : wordSet) {
                    if(!validate(word, begin)) continue;
                    if(endSet.contains(word)) return level + 1;
                    if(visited.contains(word)) continue;
                    beginSetTmp.add(word);
                    visited.add(word);
                }
            }
            beginSet = beginSetTmp;
        }
        return 0;
    }

    private boolean validate(String word, String begin) {
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != begin.charAt(i)){
                if(++index > 1) return false;
            }
        }
        return true;
    }


    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<char[]> wordSet = wordList.stream().map(String::toCharArray).collect(Collectors.toSet());
        Queue<char[]> queue = new LinkedList<>();
        queue.offer(beginWord.toCharArray());
        wordSet.remove(beginWord.toCharArray());
        int level = 1;
        while (!queue.isEmpty()) {
            level++;
            // queue的长度动态变化, 不能直接使用
//            for (int i = 0; i < queue.size(); i++) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] oldChar = queue.poll();
                Iterator<char[]> iterator = wordSet.iterator();
                while (iterator.hasNext()) {
                    char[] newChars = iterator.next();
                    if (!validate1(newChars, oldChar)) continue;
                    if (String.valueOf(newChars).equals(endWord)) return level;
                    queue.offer(newChars);
                    iterator.remove();
                }
            }
        }
        return 0;
    }

    private boolean validate1(char[] newChars, char[] oldChars) {
        int index = 0;
        for (int i = 0; i < newChars.length; i++) {
            if (newChars[i] != oldChars[i]) {
                if (++index > 1) return false;
            }
        }
        return true;
    }
}
