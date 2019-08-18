package com.stack;

import com.array.Array;

public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    public ArrayStack() {
        this.array = new Array<>();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public String toString() {
        return "tail->" + array + "->head";
    }
}
