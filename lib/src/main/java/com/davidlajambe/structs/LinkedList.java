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
        if (this.head == null) {
            throw new RuntimeException("Cannot execute remove() on an empty LinkedList");
        } else if (this.head.data.equals(t)) {
            this.head = null;
            return;
        }

        Node<T> n = this.head.next;
        Node<T> n_prev = this.head;
        while (n != null) {
            if (n.data.equals(t)) {
                n_prev.next = n.next;
                return;
            }
            n_prev = n;
            n = n.next;
        }
        throw new RuntimeException("Node does not exist in LinkedList");
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

    public boolean containsNode(T t) {
        Node<T> n = this.head;
        while (n != null) {
            if (n.data.equals(t)) return true;
            n = n.next;
        }
        return false;
    }
}
