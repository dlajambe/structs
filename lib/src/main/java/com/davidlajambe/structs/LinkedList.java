package com.davidlajambe.structs;

/**A sequence of reference-linked nodes allowing for dynamic data storage.*/
public class LinkedList<T> {
    Node<T> head;

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
    }

    public void remove(T t) {
        
    }

    public int size() {
        Node<T> n = this.head;
        int size = 0;
        while (n != null) {
            size += 1;
            n = n.next;
        }
        return size;
    }
}
