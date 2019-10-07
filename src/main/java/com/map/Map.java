package com.map;

/**
 * @Author xuwei
 * @Date 2019-09-15
 * @Version V1.0
 **/
public interface Map<K, V> {
    void put(K key, V value);

    boolean contains(K key);

    V remove(K key);

    V get(K key);

    int getSize();

    boolean isEmpty();
}
