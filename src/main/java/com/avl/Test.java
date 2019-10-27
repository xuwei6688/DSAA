package com.avl;

import com.FileOperation;

import java.util.ArrayList;

/**
 * @Author xuwei
 * @Date 2019-10-27
 * @Version V1.0
 **/
public class Test {
    public static void main(String[] args){

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("/Users/xuwei/IdeaProjects/dsaa/src/main/java/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }



            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));

            System.out.println("is BST : " + map.isBST());
            System.out.println("is Balanced : " + map.isBalanced());

            for (String word : words) {
                map.remove(word);
                if (!map.isBalanced() || !map.isBST()) {
                    throw new IllegalArgumentException();
                }
            }
        }

        System.out.println();
    }
}
