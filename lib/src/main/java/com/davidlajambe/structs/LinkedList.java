package com.davidlajambe.structs;

public class LinkedList<T> {
    Node<T> head;
    long length = 0;

    public void append(T t) {
        if (this.head == null) {
            this.head = new Node<T>(t);
        } else {
            Node<T> n = this.head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = new Node<T>(t);
        }
        ++this.length;
    }

    public long size() {
        return this.length;
    }
}
