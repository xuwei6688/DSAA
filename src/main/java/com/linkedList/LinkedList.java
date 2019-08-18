package com.linkedList;

public class LinkedList<E> {
    public class Node<E>{
        public E node;
        public Node<E> next;

        public Node(E node, Node<E> next) {
            this.node = node;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "node=" + node +
                    ", next=" + next +
                    '}';
        }
    }

    private Node<E> dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node<>(null, null);
        this.size = 0;
    }

    public boolean isEmpty() {
        return dummyHead.next == null;
    }

    public int getSize() {
        return size;
    }

    /**
     * 向指定索引处插入元素（练习）
     * @param e
     * @param index
     */
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index must >=0 && <= size");
        }

        //找到插入位置的前一个节点
        Node<E> pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        //1.新建一个节点 2.新建节点的next指向前一个节点的next 2.前一个节点的next指向新建节点
        pre.next = new Node<>(e, pre.next);
        size++;
    }

    public void addLast(E e) {
        add(e, size);
    }

    public void addFirst(E e) {
        add(e, 0);
    }

    /**
     * 练习：获取元素
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index must >= 0 && < size");
        }
        Node<E> pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        return pre.next.node;
    }

    public E getFirst() {
        return get(0);
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
        Node<E> pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        E removed = pre.next.node;

        //这里有两种可能 1.被删除的节点后边还有节点  2.被删除的节点是最后一个节点
        if (index == size - 1) {
            pre.next = null;
        }else {
            pre.next = pre.next.next;
        }
        size--;
        return removed;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 判断是否包含元素
     * @param e
     * @return
     */
    public boolean contain(E e) {
        if (e == null) {
            return false;
        }
        Node<E> current = dummyHead.next;
        while (current != null) {
            if (e.equals(current.node)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void removeAll(E e) {
        this.dummyHead.next = removeAllElement(dummyHead.next, e);
    }

    /**
     * 利用递归删除链表中所有的 e 元素
     * @param e
     */
    private Node<E> removeAllElement(Node<E> head, E e) {

        if (head == null) {
            return null;
        }
//        //这里把链表删除一个元素看成：当前链表的头节点 + 头结点跟的子链表删除元素
//        Node<E> res = removeAllElement(head.next, e);
//        //判断头节点是否和元素相同 1.相同：返回子链表  2.不相同：返回头节点 + 头结点跟的子链表
//        if (head.node.equals(e)) {
//            return res;
//        }else {
//            head.next = res;
//            return head;
//        }

        //这个是上边写法的改进形式
        //自链表的所有和e相同的元素都剔除了
        head.next = removeAllElement(head.next, e);
        //头节点元素和e相同吗？相同就返回自链表，不相同就返回该链表
        return head.node.equals(e) ? head.next : head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<E> cur = dummyHead.next;
        while (cur != null){
            sb.append(cur.node);
            sb.append("->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
