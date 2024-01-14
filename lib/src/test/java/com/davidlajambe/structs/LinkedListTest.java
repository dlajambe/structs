package com.davidlajambe.structs;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {
    final LinkedList<Integer> list = new LinkedList<Integer>();
    final int node_1_val = 10;
    final int node_2_val = 20;

    @Test public void testConstructor() {
        assertEquals("LinkedList should be empty after initialization", 0, list.size());
    }

    @Test public void testSize() {
        assertEquals(0, list.size());

        list.append(node_1_val);
        assertEquals(1, list.size());

        list.append(node_2_val);
        assertEquals(2, list.size());
    }

    @Test public void testAppendAndRemove() {

        // Section 1 - test append()
        list.append(node_1_val);
        assertTrue("List size should be 1 after adding 1 node", list.size() == 1);
        assertEquals(
            "The first node should have a value of " + Integer.toString(node_1_val) + " after adding 1 node", 
            node_1_val, (int)list.head.data);

        list.append(node_2_val);
        assertEquals("List size should be 2 after adding 2 nodes", 2, list.size());
        assertEquals(
            "The first node should still have a value of " + Integer.toString(node_1_val) + " after adding 2 nodes", 
            node_1_val, (int)list.head.data);
        assertEquals(
            "The second node should have a value of " + Integer.toString(node_2_val), 
            node_2_val, (int)list.head.next.data);

        // Section 2 - test remove()
        list.remove(node_2_val);
        assertEquals("List size should be 1 after removing node 2", 1, list.size());
        assertEquals(
            "Node 1 should still have a value of " + Integer.toString(node_1_val) + " after removing node 2", 
            node_1_val, (int)list.head.data);
        assertFalse(
            "Node 2 should no longer be in the LinkedList after removal",
            list.containsNode(node_2_val));

        list.remove(node_1_val);
        assertEquals("List should be empty after removing Node 1", 0, list.size());
        assertFalse(
            "Node 2 should no longer be in the LinkedList after removal",
            list.containsNode(node_1_val));
    }
}
