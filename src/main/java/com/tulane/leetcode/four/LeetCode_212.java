package com.tulane.leetcode.four;

import java.util.*;

/**
 * Created by Tulane
 * 2019/12/10
 */
public class LeetCode_212 {

    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private Set<String> list = new HashSet<>();
    private boolean[][] memo;
    private Trie trie;

    public List<String> findWords(char[][] board, String[] words) {
        trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        memo = new boolean[board.length][];
        for (int i = 0; i < board.length; i++) {
            memo[i] = new boolean[board[i].length];
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                dfs(board, row, col, new StringBuilder());
            }
        }
        return new ArrayList<>(list);
    }

    private void dfs(char[][] board, int row, int col, StringBuilder strb) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[row].length || memo[row][col]) {
            return;
        }
        strb.append(board[row][col]);
        memo[row][col] = true;

        if (trie.startsWith(strb.toString())) {
            if (trie.search(strb.toString())) list.add(strb.toString());
            for (int i = 0; i < dx.length; i++) {
                dfs(board, row + dx[i], col + dy[i], strb);
            }
        }
        memo[row][col] = false;
        strb.deleteCharAt(strb.length() - 1);
    }


    class Trie {

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private TrieNode searchPrefix(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    return null;
                }
                node = node.get(currentChar);
            }
            return node;
        }

        class TrieNode {

            private TrieNode[] links;
            private final int R = 26;
            private boolean isEnd;

            public TrieNode() {
                links = new TrieNode[R];
            }

            public boolean containsKey(char ch) {
                return links[ch - 'a'] != null;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public void put(char ch, TrieNode node) {
                links[ch - 'a'] = node;
            }

            public void setEnd() {
                isEnd = true;
            }

            public boolean isEnd() {
                return isEnd;
            }
        }
    }
}
