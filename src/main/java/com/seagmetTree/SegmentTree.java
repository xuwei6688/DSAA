package com.seagmetTree;


import java.util.Arrays;

/**
 * 线段树
 * @Author xuwei
 * @Date 2019-10-20
 * @Version V1.0
 **/
public class SegmentTree<E> {
    /** 线段树 **/
    private E[] tree;

    /** 区间值 **/
    private E[] data;

    private Merger<E> merger;

    public SegmentTree(E[] array, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[array.length];
        for (int i = 0; i < array.length; i++) {
            data[i] = array[i];
        }

        tree = (E[])new Object[array.length * 4];
        buildSegmentTree(0, 0, data.length - 1);
    }

    //在treeIndex的位置创建表示[l,r]的线段树
    public void buildSegmentTree(int treeIndex, int l, int r) {
        //叶子节点，实际表示数据
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }
        int leftChild = leftChildIndex(treeIndex);
        int rightChild = rightChildIndex(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftChild, l, mid);
        buildSegmentTree(rightChild, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);
    }


    public E get(int queryL, int queryR) {
        return get(0, 0, data.length -1, queryL, queryR);
    }

    //在以treeIndex为根的线段树的[l,r]范围中，搜索区间[queryL,queryR]的值
    public E get(int treeIndex, int l, int r, int queryL, int queryR) {
        //查找到了
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftChild = leftChildIndex(treeIndex);
        int rightChild = rightChildIndex(treeIndex);
        if (queryL >= mid + 1)
            return get(rightChild, mid + 1, r, queryL, queryR);
        else if (queryR <= mid)
            return get(leftChild, l, mid, queryL, queryR);

        //区间横跨左右子树
        E left = get(leftChild, l, mid, queryL, mid);
        E right = get(rightChild, mid + 1, r, mid + 1, queryR);
        return merger.merge(left, right);
    }

    public void set(int index, E e) {
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    public void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftChild = leftChildIndex(treeIndex);
        int rightChild = rightChildIndex(treeIndex);
        if (index >= mid + 1) {
            set(rightChild, mid+1,r, index,e);
        } else if (index < mid) {
            set(leftChild, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]);
    }

    public int getSize() {
        return data.length;
    }

    public boolean isEmpty() {
        return data.length == 0;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("index is Illeagl");
        }
        return data[index];
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int rightChildIndex(int index) {
        return index * 2 + 2;
    }

    @Override
    public String toString() {
        return "SegmentTree{" +
                "tree=" + Arrays.toString(tree) +
                '}';
    }
}
