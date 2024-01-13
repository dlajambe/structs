package com.davidlajambe.structs;

/**A simple reference-based building block for creating more sophisticated data structures.*/
public class Node<T> {
    public T data;
    public Node<T> next;

    Node(T t) {
        this.data = t;
    }
}
