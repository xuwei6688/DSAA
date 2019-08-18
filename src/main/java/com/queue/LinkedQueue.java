package com.queue;

import com.linkedList.LinkedList;

public class LinkedQueue<E> implements Queue<E> {
    private LinkedList<E> linkedList;

    public LinkedQueue() {
        linkedList = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void enQueue(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E deQueue() {
        return linkedList.removeFirst();
    }

    @Override
    public E getFront() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        return "队列头" + linkedList;
    }
}
