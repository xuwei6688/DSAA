package com.queue;

public class Test {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedQueue<>();
        queue.enQueue("A");
        queue.enQueue("B");
        queue.enQueue("C");
        queue.enQueue("D");
        System.out.println(queue);
        queue.deQueue();
        queue.deQueue();
        System.out.println(queue);
        queue.deQueue();
        queue.deQueue();
        System.out.println(queue);
    }
}
