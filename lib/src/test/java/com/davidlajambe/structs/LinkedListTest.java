package com.davidlajambe.structs;

import org.junit.Test;
import static org.junit.Assert.*;

public class LinkedListTest {

    @Test public void size() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertTrue("size() should return the length attribute", list.length == list.size());
    }

    @Test public void append() {
        LinkedList<Integer> list = new LinkedList<Integer>();
        assertTrue("List length should be 0 after initialization", list.length == 0);

        Integer node_1_val = 10;
        list.append(node_1_val);
        assertTrue("List length should be 1 after adding 1 node", list.length == 1);
        assertTrue(
            "The first node should have a value of " + Integer.toString(node_1_val) + " after adding 1 node", 
            list.head.data == node_1_val);
        
        Integer node_2_val = 20;
        list.append(node_2_val);
        assertTrue("List length should be 2 after adding 2 nodes", list.length == 2);
        assertTrue(
            "The first node should still have a value of " + Integer.toString(node_1_val) + " after adding 2 nodes", 
            list.head.data == node_1_val);
        assertTrue(
            "The second node should have a value of " + Integer.toString(node_2_val), 
            list.head.next.data == node_2_val);
    }
}
