package com.stack;

public class Test {
    public static void main(String[] args) {
        Stack<String> stack = new LinkedStack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        System.out.println(stack);
        String peek = stack.peek();
        System.out.println(peek);
        String pop = stack.pop();
        System.out.println(pop);
        System.out.println(stack);
        System.out.println(stack.getSize());
        System.out.println(stack.isEmpty());

        System.out.println(3/2);
    }
}
