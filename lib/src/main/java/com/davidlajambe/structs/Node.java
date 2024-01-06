package com.davidlajambe.structs;

public class Node<T> {
    public T data;
    public Node<T> next = null;

    Node(T t) {
        this.data = t;
    }
}
