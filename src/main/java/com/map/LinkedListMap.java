package com.map;

/**
 * 基于链表的映射实现
 * @Author xuwei
 * @Date 2019-09-15
 * @Version V1.0
 **/
public class LinkedListMap<K,V> implements Map<K,V> {

    private class Node{
         K key;
         V value;
         Node next;

         Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

         Node() {
        }
    }

    private int size;
    private Node dummyHead;

    public LinkedListMap() {
        this.size = 0;
        this.dummyHead = new Node() ;
    }

    @Override
    public void put(K key, V value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
        }else{
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        }
    }

    /**
     * 找到指定key对应的节点
     * @param key
     * @return Node
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V remove(K key) {
        Node preNode = dummyHead;

        //找到待删除节点的前一个节点
        while (preNode.next != null) {
            if (preNode.next.key.equals(key)) {
                break;
            }
            preNode = preNode.next;
        }

        V value = null;
        //删除节点
        if (preNode.next != null) {
            value = preNode.next.value;
            preNode.next = preNode.next.next;
            size--;
        }

        return value;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);

        return  node == null ? null : node.value;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.key);
            sb.append("=");
            sb.append(cur.value);
            sb.append(", ");
            cur = cur.next;
        }
        sb.delete(sb.length() - 1, sb.length() - 1);
        sb.append("}");

        return sb.toString();
    }
}
