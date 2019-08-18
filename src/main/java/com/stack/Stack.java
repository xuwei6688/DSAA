package com.stack;

public interface Stack<E> {
    boolean isEmpty();

    E pop();

    E peek();

    void push(E e);

    int getSize();

}
