package com.tulane.leetcode.four;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Tulane
 * 2019/12/10
 */
public class LeetCode_127 {

    public static void main(String[] args) {
        new LeetCode_127().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> headMemo = new HashSet<>();
        Set<String> tailMemo = new HashSet<>();
        Set<String> head = new HashSet<>();
        Set<String> tail = new HashSet<>();
        head.add(beginWord);
        tail.add(endWord);
        headMemo.add(beginWord);
        tailMemo.add(endWord);

        int step = 0;
        while(!head.isEmpty() && !tail.isEmpty()){
            step++;
            if(head.size() > tail.size()){
                Set<String> tmp = head;
                head = tail;
                tail = tmp;
                Set<String> tmpMemo = headMemo;
                headMemo = tailMemo;
                tailMemo = tmpMemo;
            }
            Set<String> tmpSet = new HashSet<>();
            for (String word : head) {
                for (String changeWord : wordList) {
                    if(headMemo.contains(changeWord) || !valid(word, changeWord)) continue;
                    if(tail.contains(changeWord)) return step + 1;
                    headMemo.add(changeWord);
                    tmpSet.add(changeWord);
                }
            }
            head = tmpSet;
        }
        return 0;
    }



    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> memo = new HashSet<>();
        Queue queue = new LinkedList();
        queue.offer(beginWord);
        memo.add(beginWord);

        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = (String) queue.poll();
                for (String changeWord : wordList) {
                    if (memo.contains(changeWord) || !valid(word, changeWord)) continue;
                    if (endWord.equals(changeWord)) return step;
                    memo.add(changeWord);
                    queue.offer(changeWord);
                }
            }
        }
        return 0;
    }

    private boolean valid(String startWord, String changeWord) {
        int index = 0;
        for (int i = 0; i < startWord.length(); i++) {
            if (startWord.charAt(i) != changeWord.charAt(i)) {
                if (++index > 1) return false;
            }
        }
        return index == 1;
    }
}
