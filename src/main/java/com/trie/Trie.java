package com.trie;

import java.util.TreeMap;

/**
 * @Author xuwei
 * @Date 2019-10-26
 * @Version V1.0
 **/
public class Trie {
    private class Node{
        /** 表示从根节点到当前节点组成的字符是否是一个单词 **/
        boolean isWord;
        /** 维护了一个map,表示这个节点所有的子节点，key值表示当前字符的下一个字符，value表示下一个节点的引用 **/
        TreeMap<Character, Node> next;

        int value;

         Node(boolean isWord) {
            this.value = 0;
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        Node(int value) {
             this.value = value;
             this.isWord = false;
            this.next = new TreeMap<>();
        }
         Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        this.root = new Node();
    }

    public int getSize() {
        return size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        //可能添加的单词已经在Trie中，这里做个检查
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public void addWithValue(String word, int value) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

       cur.value = value;
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    /**
     * 判断给定字符串是否是Trie中某个单词的前缀
     * @param str
     * @return
     */
    public boolean isPrefix(String str) {
        Node cur = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    /**
     * 查询给定单词是否在Trie中
     * 支持用 .表示任意字符
     * @param word
     * @return
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }

        char c = word.charAt(index);
        if (c != '.') {
            if (node.next.get(c) == null) {
                return false;
            }
            return match(node.next.get(c), word, ++index);
        }else{
            for (Node next : node.next.values()) {
                return match(next, word, ++index);
            }
            return false;
        }
    }

    /**
     * 计算出所有以给定字符串为前缀的单词的和
     * @param prefix 前缀
     * @return 和
     */
    public int sum(String prefix) {
        //1.首先找到前缀所处节点
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        //2.计算该节点下所有包含单词的和
        return sum(cur);
    }

    private int sum(Node node) {
        if (node.next == null) {
            return 0;
        }
        int sum = node.value;
        for (Node n : node.next.values()) {
            sum += sum(n);
        }
        return sum;
    }
}
