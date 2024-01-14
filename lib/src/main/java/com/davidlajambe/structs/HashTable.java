package com.davidlajambe.structs;

import java.util.ArrayList;

public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private ArrayList<LinkedList<Entry<K, V>>> table;

    public HashTable() {
        this(HashTable.DEFAULT_CAPACITY);
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.table = new ArrayList<LinkedList<Entry<K, V>>>(this.capacity);

        for (int i = 0; i < this.capacity; i++) {
            LinkedList<Entry<K, V>> new_list = new LinkedList<Entry<K, V>>();
            this.table.add(new_list);
        }
    }

    public void put(K key, V value) {
        final Entry<K, V> pair = new Entry<K, V>(key, value);
        
        final int idx = this.getIndex(key);
        final LinkedList<Entry<K, V>> list = this.table.get(idx);
        
        if (list.head == null) {
            // If the list is empty, then the new pair can be added trivially
            list.head = new Node<Entry<K, V>>(pair);
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
        Node<Entry<K, V>> n = list.head;
        while (n.next != null) {
            if (n.data.key == pair.key) {
                n.data.value = pair.value;
                return;
            }
            n = n.next;
        }

        // If this section is reached, then the key does not already exist in the list
        // and should be appended
        n.next = new Node<Entry<K, V>>(pair);
    }

    public void remove(K key) {
        final int idx = this.getIndex(key);
        final LinkedList<Entry<K, V>> list = this.table.get(idx);
        if (list == null) {
            throw new RuntimeException("Key does not exist in HashTable");
        }

        if (list.head.data.key.equals(key)) {
            list.head = list.head.next;
            return;
        }

        Node<Entry<K, V>> n_prev = list.head;
        Node<Entry<K, V>> n = list.head.next;
        while (n != null) {
            if (n.data.key.equals(key)) {
                n_prev.next = n.next;
                return;
            }
            n_prev = n;
            n = n.next;
        }
        throw new RuntimeException("Key does not exist in HashTable");
    }

    public boolean containsKey(K key) {
        final int idx = this.getIndex(key);
        final LinkedList<Entry<K, V>> list = this.table.get(idx);
        Node<Entry<K, V>> n = list.head;
        while (n != null) {
            if (n.data.key.equals(key)) return true;
            n = n.next;
        }
        return false;
    }

    public V get(K key) {
        final int idx = this.getIndex(key);
        LinkedList<Entry<K, V>> linkedList = this.table.get(idx);
        Node<Entry<K, V>> n = linkedList.head;
        while (n != null) {
            if (n.data.key.equals(key)) return n.data.value;
            n = n.next;
        }
        throw new RuntimeException("Key does not exist in HashTable");
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < this.capacity; i++) {
            size += this.table.get(i).size();
        }
        return size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    static public int getDefaultCapacity() {
        return HashTable.DEFAULT_CAPACITY;
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % this.capacity);
    }
}
