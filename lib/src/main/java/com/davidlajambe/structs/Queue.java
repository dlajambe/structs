package com.davidlajambe.structs;

/**Stores data on a first-in-first-out basis.*/
public class Queue<T> {
    Node<T> first;
    Node<T> last;

    public boolean isEmpty() {
        return this.first == null;
    }

    public void add (T t) {
        Node<T> new_node = new Node<T>(t);

        if (this.first == null) {
            this.first = new_node;
        } else {
            this.last.next = new_node;
        }
         this.last = new_node;
    }

    public T remove() {
        if (this.first == null) throw new NullPointerException("Cannot execute remove() on an empty Queue");
        T removed_data = this.first.data;
        this.first = this.first.next;

        if (this.first == null) {
            this.last = null;
        }

        return removed_data;
    }

    public T peek() {
        if (this.first == null) throw new NullPointerException("Cannot execute peek() on an empty Queue");
        return this.first.data;
    }

    public int size() {
        int size = 0;
        Node<T> n = this.first;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }

}

