package com.unionfind;

/**
 * @Author xuwei
 * @Date 2019-10-27
 * @Version V1.0
 **/
public class UnionFind1 implements UF{
    /** index表示元素索引，id表示元素所在集合 **/
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    public int getSize() {
        return id.length;
    }

    /**
     * 找到元素所在集合
     * @param p
     * @return
     */
    public int find(int p) {
        if (p < 0 || p > id.length) {
            throw new IllegalArgumentException();
        }
        return id[p];
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

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID){
                id[i] = qId;
            }
        }
    }
}
