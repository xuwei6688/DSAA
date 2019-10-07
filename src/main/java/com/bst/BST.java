package com.bst;

import com.queue.ArrayQueue;
import com.queue.Queue;
import com.stack.Stack;

/**
 * 二分搜索树
 * @Author xuwei
 * @Date 2019-09-14
 * @Version V1.0
 **/
public class BST<E extends Comparable<E>> {
    private class Node{
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
//   插入元素的方法 一
//    /**
//     * 添加新元素E
//     * @param e
//     */
//    public void add(E e) {
//        if (root == null) {
//            root = new Node(e);
//            size++;
//        }else{
//            add(root, e);
//        }
//    }
//
//    /**
//     * 向以node为根节点的二分搜索树种添加元素e
//     * @param node 二分搜索树的根节点
//     * @param e 元素
//     */
//    private void add(Node node, E e) {
//        if (e.equals(node.e)) {
//            return;
//        } else if (e.compareTo(node.e) < 0 && node.left == null) {
//            node.left = new Node(e);
//            size++;
//            return;
//        } else if (e.compareTo(node.e) > 0 && node.right == null) {
//            node.right = new Node(e);
//            size++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0) {
//            add(node.left, e);
//        }else {
//            add(node.right, e);
//        }
//    }

    /**
     * 插入元素的方法一有几点可以改进：
     * 1.方法一把根节点单独考虑
     * 2.方法一把null单独看，其实可以把null也看做节点
     * @param e
     */
    public void add(E e) {
       root =  add(root, e);
    }

    private Node add(Node node, E e) {
        //把null也看做node,当遍历到null节点时说明节点就要加到这里
        if (node == null) {
            node = new Node(e);
            size++;
            return node;
        }

        // 如果e 小于当前节点的元素e，那么就向左子树插入元素
        // 如果e 大于当前节点的元素e，那么就向右子树插入元素
        // 为什么需要返回引用呢？返回引用是为了可以把新建的节点关联到原来的树上
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        }else{
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
       return contains(root, e);
    }


    /**
     * 把null也看做节点
     * 递归查询，如果当前的节点为null，说明已经查询到头了，但是仍未发现找到和元素e相同的元素
     * 如果当前节点不为null,判断当前节点是否就是要寻找的节点，如果是的话就返回true,否则在子树中寻找。
     * @param node 根节点
     * @param e 元素e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (e.equals(node.e)) {
            return true;

        // 元素小于当前节点元素，在左子树中寻找
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        }
        //元素大于当前节点元素，在右子树中寻找
        else {
            return contains(node.right, e);
        }
    }

    /**
     * 前序遍历：节点 -》左子树 -》右子树
     */
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历：左子树 -》节点 -》 右子树
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后续遍历：左子树 -》右子树 -》 节点
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 层序遍历：按层数从上到下，从左到右遍历
     *
     * ///////////////////
     * //	   5        //
     * //	/	\       //
     * //   3	  6     //
     * //  / \     \    //
     * // 2   4     8   //
     *
     * 利用队列实现，把节点放入队列，当出队列是再依次把左右子节点也放入队列。
     * 队首           队尾
     * 5
     * 3 6                      5
     * 6 2 4                    3
     * 2 4 8                    6
     * 4 8                      2
     * 8                        4
     *                          8
     */
    public void levelOrder() {
        Queue<Node> queue = new ArrayQueue<>();
        queue.enQueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.deQueue();
            System.out.println(node.e);

            if (node.left != null)
                queue.enQueue(node.left);

            if (node.right != null)
                queue.enQueue(node.right);
        }
    }

    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("bst is empty!");
        }
        return minimum(root).e;
    }

    //查找给定二分搜索树的最小节点
    private Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("bst is empty!");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node);
    }

    /**
     * 删除最小元素，分两种情况
     * 1.最小元素没有没有右子节点，直接删除即可
     * 2.最小元素有右子节点，删除节点，把右子节点连到删除节点的父节点上。
     */
    public E removeMin() {
        E e = minimum();
        root = removeMin(root);
        return e;
    }

    // 删除掉以node为根节点的二分搜索树的最小节点
    // 返回删除节点后的新二分搜索树的根
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            size--;
            return right;
        }

        //把删除最小节点分解成删除当前二分搜索树左子树的最小节点
        node.left = removeMin(node.left);
        return node;
    }

    public void remove(E e) {
        root = remove(root, e);
    }

    //删除以node为根节点的二分搜索树的元素e,并返回删除元素e后的二分搜索树的根
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else {
            //实际删除
            if (node.left == null) {
                size--;
                return node.right;
            }
            if (node.right == null) {
                size--;
                return node.left;
            }

            //删除节点左右子树都有
            // 1.找到删除节点的后继节点 d
            // 2.d.right = 删除节点的右子树（不包含d）
            // 3.d.left = 删除节点的左子树
            // 4.把d连到删除节点的父节点上

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            return successor;
        }
    }
}
