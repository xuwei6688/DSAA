package com.queue;

/**
 * 队列是先进先出的线性表（FIFO）。队列只允许在后端进行插入操作，在前端进行删除操作。
 * @param <E>
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enQueue(E e);

    E deQueue();

    E getFront();

}
