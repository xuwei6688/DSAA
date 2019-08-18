package com.linkedList;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");

        System.out.println(list);
        System.out.println(list.contain("C"));
        list.removeLast();
        list.removeFirst();
        System.out.println(list);

        list.addLast("C");
        list.addLast("F");
        list.addLast("C");
        list.addLast("C");
        list.removeAll("C");
        System.out.println(list);
    }
}

