package com.unionfind;

/**
 *
 **/
public class UnionFind4 implements UF{
    //当index != value时 value表示父节点index
    //当index == value时 value表示集合id
    private int[] parent;

    //rank为以index为根的树的高度
    private int[] rank;

    //初始时每个节点的父节点都是自己，这样就是说所有的节点都属于不同的集合
    public UnionFind4(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        //rank低的树向rank高的树合并
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        }else {
            parent[qRoot] = pRoot;
            rank[qRoot] += 1;
        }

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
