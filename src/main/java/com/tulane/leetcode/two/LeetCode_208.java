package com.tulane.leetcode.two;

/**
 * 实现Trie(前缀树)
 * Created by Tulane
 * 2019/11/24
 */
public class LeetCode_208 {

    class TrieNode {
        private int capacity = 26;
        private boolean endFlag = false;
        private TrieNode[] lines;

        public TrieNode() {
            this.lines = new TrieNode[capacity];
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

    final private TrieNode trieNode;

    /** Initialize your data structure here. */
    public LeetCode_208() {
        trieNode = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = trieNode;
        char[] chArr = word.toCharArray();
        for (char ch : chArr) {
            if(!node.containsKey(ch)){
                node.put(ch, new TrieNode());
            }
            node = node.get(ch);
        }
        node.setEndFlag(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = findLastTrieNode(word);
        return node != null && node.isEndFlag();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = findLastTrieNode(prefix);
        return node != null;
    }

    private TrieNode findLastTrieNode(String word){
        TrieNode node = trieNode;
        char[] chArr = word.toCharArray();
        for (char ch : chArr) {
            if(!node.containsKey(ch)){
                return null;
            }
            node = node.get(ch);
        }
        return node;
    }
}
