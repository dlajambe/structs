package com.davidlajambe.structs;

import org.junit.Test;
import static org.junit.Assert.*;

public class HashTableTest {
    final int CAPACITY = 10;
    HashTable<String, Integer> hash_table = new HashTable<String, Integer>(this.CAPACITY);
    Pair<String, Integer> newPairA = new Pair<String, Integer>("a", 1);
    Pair<String, Integer> newPairB = new Pair<String, Integer>("b", 2);
    Pair<String, Integer> newPairC = new Pair<String, Integer>("c", 3);

    @Test public void testPutAndGet() {

        // Tests the first put() method in which a key-value pair in the argument
        hash_table.put(newPairA.key, newPairA.value);
        assertEquals(newPairA.value, newPairA.value, hash_table.get(newPairA.key));

        // Tests the overloaded put() method in which the key and value are separate arguments
        hash_table.put(newPairB.key, newPairB.value);
        assertEquals(newPairB.value, hash_table.get(newPairB.key));

        // This should overwrite the original pairA
        hash_table.put(newPairA.key, newPairC.value);
        assertEquals(newPairC.value, hash_table.get(newPairA.key));

        // The final test involves filling up the hash table beyond its capacity to guarantee that collisions occur
        for (int i = 0; i < this.CAPACITY * 1000; i++) {
            String key = new String(Character.toString((char)i));
            Integer value = i;
            hash_table.put(key, value);
            assertEquals(hash_table.get(key), value);
        }
    }

    @Test public void append() {

    }
}