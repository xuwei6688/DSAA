package com.array;

public class Test {
    public static void main(String[] args) {
        Array<String> array = new Array<>(2);
        array.add(0, "A");
        array.add(1, "B");
        array.add(2, "C");
        array.addLast("D");
        array.addLast("E");
        array.addLast("F");
        System.out.println(array);
        array.remove(4);
        array.remove(3);
        array.remove(2);
        array.remove(1);
        array.remove(0);

        System.out.println(array);
    }
}
