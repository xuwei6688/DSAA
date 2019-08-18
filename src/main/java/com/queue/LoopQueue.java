package com.queue;

import com.array.Array;

/**
 * 循环队列
 * 依靠数组和队列头部和队列尾部的索引实现
 * front是当前队列头部的位置，tail当前队尾的下一个位置
 * 当front == tail 时，队列为空
 * 当front == (tail + 1) % capacity 时，说明队列已经满了
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {
    private E [] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enQueue(E e) {
        // 假设capacity = 10，front = 5, tail = 4，这时tail就不能再直接增加了（如果直接增加 5=5,说明队列为空）
        // 这时需要扩容
        if ((tail + 1) % data.length == front) {
            resSize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("queue is empty!");
        }
        E removed = data[front];
        data[front] = null;
        //原来第二个元素作为新的队首
        front = (front + 1) % data.length;
        size--;

        //判断是否需要缩容
        if (size == getCapacity() / 4) {
            resSize(getCapacity() /2);
        }
        return removed;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("queue is empty");
        return data[front];
    }

    private int getCapacity() {
        return data.length - 1;
    }

    private void resSize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("队首：");

        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            sb.append("->");
        }
        sb.append("队尾");
        return sb.toString();
    }
}
