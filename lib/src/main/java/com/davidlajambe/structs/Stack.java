package com.davidlajambe.structs;

/** Stores data on a last-in-first-out basis.*/
public class Stack<T> {
    Node<T> top;

    public T peek() {
        if (this.top == null) throw new NullPointerException("Cannot execute peek() on an empty Stack");
        return top.data;
    }

    public boolean isEmpty() {
        if (top == null) {
            return true;
        } else {
            return false;
        }
    }

    public void push(T t) {
        Node<T> new_top = new Node<T>(t);
        new_top.next = this.top;
        this.top = new_top;
    }

    public T pop() {
        if (this.top == null) throw new NullPointerException("Cannot execute pop() on an empty Stack");
        T removed_val = this.top.data;
        this.top = this.top.next;
        return removed_val;
    }

    public int size() {
        int size = 0;
        Node<T> n = this.top;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }
}
