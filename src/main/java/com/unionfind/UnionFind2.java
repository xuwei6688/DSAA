package com.unionfind;

/**
 * 基于树的并查集，还是利用数组实现，不同的是数组元素的含义是父节点索引
 **/
public class UnionFind2 implements UF{
    //当index != value时 value表示父节点index
    //当index == value时 value表示集合id
    private int[] parent;

    //初始时每个节点的父节点都是自己，这样就是说所有的节点都属于不同的集合
    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qId = find(q);

        if (pID == qId) {
            return;
        }

        parent[pID] = qId;
    }

    //找到元素p所在集合
    public int find(int p) {
        if (p < 0 || p > parent.length) {
            throw new IllegalArgumentException();
        }

        //当p的parent指向自己时，说明p就是根节点，p的值就是集合
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

}
