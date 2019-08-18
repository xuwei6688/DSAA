package com.array;


import java.util.Arrays;

public class Array<E> {
    private E data[];
    private int size;

    public Array(int capacity) {
        this.data =  (E[]) new Object[capacity];
    }

    public Array() {
        this.data = (E[]) new Object[10];
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向数组中添加元素
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index must >= 0 and <= size");
        }

        if (size == getCapacity()) {
            reSize(getCapacity() * 2);
        }

        if (size == 0) {
            data[0] = e;
            size++;
            return;
        }

        //所有元素向后移动一位
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        //把元素插入指定index处
        data[index] = e;
        size++;
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E removeFirst() {
       return remove(0);
    }

    /**
     * 查找元素所在位置
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index must >=0 && < size");
        }

        return data[index];
    }

    public E getLast() {
        return get(size - 1);
    }

    /**
     * 删除指定位置的元素
     * @param index
     * @return
     */
    public E remove(int index) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index must >=0 && < size");
        }

        E e = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null;

        //如果实际使用容量是总容量的四分之一，那么缩减容量为原来的二分之一，这样可以预留出四分之一的容量，防止复杂度震荡。
        if (size == getCapacity() / 4) {
            reSize(getCapacity() / 2);
        }

        return e;
    }

    public E removeLast() {
       return remove(size - 1);
    }

    /**
     * 删除元素
     * @param e
     * @return
     */
    public int removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
        return index;
    }

    public int getCapacity() {
        return data.length;
    }

    private void reSize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        //数组拷贝
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size + ",capacity=" + getCapacity() +
                '}';
    }
}
