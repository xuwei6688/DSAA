package com.trie;

import com.FileOperation;

import java.util.ArrayList;

/**
 * @Author xuwei
 * @Date 2019-10-26
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args) {

        Trie trie = new Trie();
        trie.add("banana");
        trie.add("bana");
        System.out.println(trie.search("banana"));
        System.out.println(trie.search("ban.na"));
        System.out.println(trie.search("ban..a"));
        System.out.println(trie.search("......"));
        System.out.println(trie.search(".."));

        Trie t = new Trie();
        t.addWithValue("abc", 1);
        t.addWithValue("abcd", 2);
        t.addWithValue("abcde", 3);
        System.out.println(t.sum("abcd"));
    }
}
