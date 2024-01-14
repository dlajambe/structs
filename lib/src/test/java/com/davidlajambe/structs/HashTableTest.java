package com.davidlajambe.structs;

import org.junit.Test;
import static org.junit.Assert.*;

public class HashTableTest {
    final int CAPACITY = 10;
    final HashTable<String, Integer> hash_table = new HashTable<String, Integer>(this.CAPACITY);
    final Entry<String, Integer> entryA = new Entry<String, Integer>("a", 1);
    final Entry<String, Integer> entryB = new Entry<String, Integer>("b", 2);
    final Entry<String, Integer> entryC = new Entry<String, Integer>("c", 3);

    @Test public void testConstructor() {
        HashTable<String, Integer> default_table = new HashTable<String, Integer>();
        assertEquals(HashTable.getDefaultCapacity(), default_table.getCapacity());

        assertEquals(this.CAPACITY, hash_table.getCapacity());
        assertEquals("HashTable should be empty after initialization", 0, hash_table.size());
    }

    @Test public void testPutAndGet() {
        // Add the first pair
        hash_table.put(entryA.key, entryA.value);
        assertEquals("The result should be the value of entryA", entryA.value, hash_table.get(entryA.key));
        assertEquals(1, hash_table.size());

        // Add the second pair
        hash_table.put(entryB.key, entryB.value);
        assertEquals("The result should be the value of entryB", entryB.value, hash_table.get(entryB.key));
        assertEquals(2, hash_table.size());

        // This should overwrite the original pairA
        hash_table.put(entryA.key, entryC.value);
        assertEquals("The result should be the value of entryC", entryC.value, hash_table.get(entryA.key));
        assertEquals(2, hash_table.size());

        // The final test involves filling up the hash table beyond its capacity to guarantee that collisions occur
        for (int i = 0; i < this.CAPACITY * 10; i++) {
            final int initial_size = hash_table.size();
            String key = Integer.toString(i);
            Integer value = i;
            hash_table.put(key, value);
            assertTrue("The table should contain the new key (" + key + ")", hash_table.containsKey(key));
            assertEquals("The result should be the new entry's value (" + value + ")", hash_table.get(key), value);

            // Adding new keys should not change the values of existing keys
            assertEquals("Adding a new entry may have affected existing entries", entryB.value, hash_table.get(entryB.key));

            final int final_size = hash_table.size();
            assertEquals("add() should increase the table size by 1" ,1, final_size - initial_size);
        }
    }

    @Test public void testContainsKey() {
        // Nothing has been added yet, so all should be false
        assertFalse("Empty tables should not contain entries", hash_table.containsKey(entryA.key));
        assertFalse("Empty tables should not contain entries", hash_table.containsKey(entryB.key));
        assertFalse("Empty tables should not contain entries", hash_table.containsKey(entryC.key));

        // The table should now contain key A
        hash_table.put(entryA.key, entryA.value);
        assertTrue(hash_table.containsKey(entryA.key));
        assertFalse(hash_table.containsKey(entryB.key));
        assertFalse(hash_table.containsKey(entryC.key));

        // The table should now contain key A and B
        hash_table.put(entryB.key, entryB.value);
        assertTrue(hash_table.containsKey(entryA.key));
        assertTrue(hash_table.containsKey(entryB.key));
        assertFalse(hash_table.containsKey(entryC.key));

        // The table should still only contain key A and B 
        hash_table.put(entryA.key, entryC.value);
        assertTrue(hash_table.containsKey(entryA.key));
        assertTrue(hash_table.containsKey(entryB.key));
        assertFalse(hash_table.containsKey(entryC.key));

        // The final test involves filling up the hash table beyond its capacity to guarantee that collisions occur
        for (int i = 0; i < this.CAPACITY * 10; i++) {
            String key =Integer.toString(i);
            Integer value = i;
            hash_table.put(key, value);
            assertTrue(hash_table.containsKey(key));

            // Add more entries are added, the table should still contain key A and B
            assertTrue(hash_table.containsKey(entryA.key));
            assertTrue(hash_table.containsKey(entryB.key));
            assertFalse(hash_table.containsKey(entryC.key));
        }
    }

    @Test public void testPutAndRemove() {
        // For these test to work, the HashTable should initially be empty
        assertEquals(0, hash_table.size());

        // Some entries are added
        hash_table.put(entryA.key, entryA.value);
        hash_table.put(entryB.key, entryB.value);
        assertTrue(hash_table.containsKey(entryA.key));
        assertTrue(hash_table.containsKey(entryB.key));
        assertEquals("The table size should be 2 after calling put() twice", 2, hash_table.size());

        // Now, removal can be tested
        hash_table.remove(entryA.key);
        assertFalse(hash_table.containsKey(entryA.key));
        assertTrue(hash_table.containsKey(entryB.key));
        assertEquals("The table size should be 1 after calling put() twice and remove() once", 1, hash_table.size());

        hash_table.remove(entryB.key);
        assertFalse(hash_table.containsKey(entryA.key));
        assertFalse(hash_table.containsKey(entryB.key));
        assertEquals("The table size should be 0 after calling put() twice and remove() twice", 0, hash_table.size());

        // The final test involves filling up the hash table beyond its capacity to guarantee that collisions occur
        for (int i = 0; i < this.CAPACITY * 10; i++) {
            String key = Integer.toString(i);
            Integer value = i;
            hash_table.put(key, value);
        }

        for (int i = this.CAPACITY * 10 - 1; i >= 0; i--) {
            final int initial_size = hash_table.size();
            String key = Integer.toString(i);
            assertTrue(hash_table.containsKey(key));

            hash_table.remove(key);
            final int final_size = hash_table.size();
            assertFalse(hash_table.containsKey(key));
            assertEquals("The table size should decrease by 1 after calling remove()", -1, final_size - initial_size);
        }
    }
}