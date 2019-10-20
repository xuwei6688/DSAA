package com.heap;

import com.array.Array;

/**
 * 二叉堆，利用Array来实现
 * @Author xuwei
 * @Date 2019-10-07
 * @Version V1.0
 **/
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    MaxHeap(int capacity) {
        this.data = new Array<>(capacity);
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回它父节点的索引
    private int parentIndex(int index){
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent!");
        }
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    /**
     * 添加元素需要考虑维护堆的结构：节点必须大于他的左右孩子
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parentIndex(index))) > 0) {
            data.swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    public E findMax() {
        return data.get(0);
    }

    /**
     * 取出最大值
     * 需要考虑取出最大值之后维护堆的结构
     * @return
     */
    public E extractMax() {
        E max = findMax();

        //交换根节点和堆尾元素
        data.swap(0, data.getSize() - 1);

        data.removeLast();
        siftDown(0);

        return max;
    }

    private void siftDown(int index) {
        while (leftChildIndex(index) < data.getSize()) {
            int j = leftChildIndex(index); //在此轮循环中 data[index]和data[j]交换位置

            //把j赋值为左右孩子中较大的那个的index
            if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(rightChildIndex(index))) < 0) {
                j = rightChildIndex(index);
            }

            //data[j]是左右孩子中较大的
            if (data.get(index).compareTo(data.get(j)) > 0) {
                break;
            }

            data.swap(index, j);
            index = j;
        }
    }

    public void replace(E e) {
        data.addLast(e);
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
    }

    //把一个二叉树整理成堆
    public void heapify(E[] data) {
        this.data = new Array<>(data);

        for (int i = parentIndex(getSize() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

}
