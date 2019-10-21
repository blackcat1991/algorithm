package com.bobohe;

/**
 * @author blackcat
 * @Description: Trie树
 * @create 2019-07-27 15:35
 */
public class Trie {

    private TrieNode root = new TrieNode('/');

    public void insert(char[] text){
        TrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int index = text[i] - 'a';
            if (p.children[index] == null){
                TrieNode newNode = new TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    public boolean find(char[] pattern){
        TrieNode p = root;
        for (int i = 0; i < pattern.length; i++) {
            int index = pattern[i] - 'a';
            if (p.children[index] == null){
                return false; //不存在
            }
            p = p.children[index];
        }
        if (p.isEndingChar == false){
            return false; //不能完成匹配
        }
        return true;
    }

    /**
     * Trie树节点
     * 假设字符串由26个英文字母组成。
     */
    public class TrieNode{
        public char data;
        //存储子节点的引用（指针）
        public TrieNode[] children = new TrieNode[26];
        //是否是一个字符串的最后一个字符节点
        public boolean isEndingChar = false;
        public TrieNode(char data){
            this.data = data;
        }
    }

}
