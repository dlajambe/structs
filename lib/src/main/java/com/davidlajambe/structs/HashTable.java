package com.davidlajambe.structs;

import java.util.ArrayList;

public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private ArrayList<LinkedList<Pair<K, V>>> pairs;

    public HashTable() {
        this(HashTable.DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.pairs = new ArrayList<LinkedList<Pair<K, V>>>(this.capacity);

        for (int i = 0; i < this.capacity; i++) {
            LinkedList<Pair<K, V>> new_list = new LinkedList<Pair<K, V>>();
            this.pairs.add(new_list);
        }
    }

    public void put(K key, V value) {
        Pair<K, V> pair = new Pair<K, V>(key, value);
        
        int idx = this.get_idx(key);
        LinkedList<Pair<K, V>> list = this.pairs.get(idx);
        
        if (list.head == null) {
            // If the list is empty, then the new pair can be added trivially
            list.head = new Node<Pair<K, V>>(pair);
            return;
        } else {
            // If the head node contains the key, then its value can be modified
            // trivially without a loop
            if (list.head.data.key == pair.key) {
                list.head.data.value = pair.value;
                return;
            }
        }

        // If the list has nodes, then a check is required to see if a node containing the key already exists
        Node<Pair<K, V>> n = list.head;
        while (n.next != null) {
            if (n.data.key == pair.key) {
                n.data.value = pair.value;
                return;
            }
            n = n.next;
        }

        // If this section is reached, then the key does not already exist in the list
        // and should be appended
        n.next = new Node<Pair<K, V>>(pair);
    }

    public void remove(K key) {

    }

    public V get(K key) {
        int idx = this.get_idx(key);
        LinkedList<Pair<K, V>> linkedList = this.pairs.get(idx);
        Node<Pair<K, V>> n = linkedList.head;
        while (n != null) {
            if (n.data.key == key) return n.data.value;
            n = n.next;
        }
        throw new RuntimeException("Key does not exist in HashTable");
    }

    int get_idx(K key) {
        return Math.abs(key.hashCode() % this.capacity);
    }
}
