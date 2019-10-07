package com.map;

/**
 * 基于二分搜索树的映射实现
 * @Author xuwei
 * @Date 2019-09-15
 * @Version V1.0
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K,V>{
    private class Node{
         K key;
         V value;
         Node left;
         Node right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
       root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = put(node.left, key, value);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = put(node.right, key, value);
            return node;
        }else {
            node.value = value;
            return node;
        }
    }

    @Override
    public boolean contains(K key) {
        return contains(root, key);
    }

    private boolean contains(Node node, K key) {
        if (node == null) {
            return false;
        }
        if (key.equals(node.key)) {
            return true;
        }
        if (key.compareTo(node.key) < 0) {
            return contains(node.left, key);
        }else{
            return contains(node.right, key);
        }
    }

    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    @Override
    public V remove(K key) {
        V v = get(key);
        root = remove(root, key);
        return v;
    }

    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) < 0) {
            return remove(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            return remove(node.right, key);
        } else {
            size--;
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            return successor;
        }
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            return null;
        }
        node.left = removeMin(node.left);
        return node;
    }


    @Override
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.equals(node.key)) {
            return node.value;
        } else if (key.compareTo(node.key) < 0) {
            return get(node.left, key);
        } else {
            return get(node.right, key);
        }
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

        preAppend(root, sb);
        sb.delete(sb.length() - 1, sb.length() - 1);
        sb.append("}");

        return sb.toString();
    }

    private void preAppend(Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        sb.append(node.key);
        sb.append("=");
        sb.append(node.value);
        sb.append(",");

        preAppend(node.left, sb);
        preAppend(node.right, sb);
    }
}
