package com.unionfind;

/**
 * @Author xuwei
 * @Date 2019-10-27
 * @Version V1.0
 **/
public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
