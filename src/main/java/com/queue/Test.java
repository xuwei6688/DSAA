package com.queue;

public class Test {
    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();

        queue.enQueue("C");
        queue.enQueue("D");
        queue.enQueue("A");
        queue.enQueue("B");
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue("A");
        System.out.println(queue.deQueue());

    }
}
