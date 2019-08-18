package com.stack;

import com.linkedList.LinkedList;

public class LinkedStack<E> implements Stack<E> {
    private LinkedList<E> linkedList;

    public LinkedStack() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public String toString() {
        return "head:" + linkedList;
    }
}
