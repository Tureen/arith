package com.tulane.leetcode.three;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词搜索
 * Created by Tulane
 * 2019/11/25
 */
public class LeetCode_212 {

    private final Trie trie = new Trie();
    private final Set<String> set = new HashSet<>();
    private boolean[][] memo;
    private final int[] dx = new int[]{-1, 1, 0, 0};
    private final int[] dy = new int[]{0, 0, -1, 1};

    public List<String> findWords(char[][] board, String[] words) {
        memo = new boolean[board.length][];
        for (int i = 0; i < board.length; i++) {
            memo[i] = new boolean[board[i].length];
        }

        for (String word : words) {
            trie.insert(word);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                dfs(board, row, col, new StringBuilder(), trie);
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, int row, int col, StringBuilder strb, Trie trie) {
        // terminator
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || memo[row][col]) return;
        strb = strb.append(board[row][col]);
        // visit add
        memo[row][col] = true;
        // 剪枝 & process & drill down
        if (trie.startsWith(strb.toString())) {
            if (trie.search(strb.toString())) set.add(strb.toString());
            for (int i = 0; i < dx.length; i++) {
                dfs(board, row + dx[i], col + dy[i], strb, trie);
            }
        }
        // clean status
        strb.deleteCharAt(strb.length() - 1);
        memo[row][col] = false;
    }


    // ------------------ 基础 -------------------------------

    /**
     * 字典树
     */
    class Trie {

        private final TrieNode trieNode;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            trieNode = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = trieNode;
            char[] chArr = word.toCharArray();
            for (char ch : chArr) {
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEndFlag(true);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = findLastNode(word);
            return node != null && node.isEndFlag();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = findLastNode(prefix);
            return node != null;
        }

        private TrieNode findLastNode(String word) {
            TrieNode node = trieNode;
            char[] chArr = word.toCharArray();
            for (char ch : chArr) {
                if (!node.containsKey(ch)) {
                    return null;
                }
                node = node.get(ch);
            }
            return node;
        }

        class TrieNode {
            private int capacity = 26;
            private TrieNode[] lines;
            private boolean endFlag;

            public TrieNode() {
                lines = new TrieNode[capacity];
            }

            public boolean containsKey(char ch) {
                return lines[ch - 'a'] != null;
            }

            public void put(char ch, TrieNode trieNode) {
                lines[ch - 'a'] = trieNode;
            }

            public TrieNode get(char ch) {
                return lines[ch - 'a'];
            }

            public boolean isEndFlag() {
                return endFlag;
            }

            public void setEndFlag(boolean endFlag) {
                this.endFlag = endFlag;
            }
        }
    }

}
