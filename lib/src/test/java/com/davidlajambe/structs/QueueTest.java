package com.davidlajambe.structs;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    Queue<Integer> queue = new Queue<Integer>();
    final int node_1_value = 0;
    final int node_2_value = 1;

    @Test public void testConstructor() {
        assertEquals("Queue should be empty after initialization", 0, queue.size());
    }
    
    @Test public void testAdd() {
        queue.add(node_1_value);
        assertEquals(
            "The first node of the queue should be " + Integer.toString(node_1_value) + " after one add", 
            node_1_value, (int)queue.first.data);
        assertEquals(
            "The last node of the queue should be " + Integer.toString(node_1_value) + " after one add", 
            node_1_value, (int)queue.last.data);
        assertEquals(
            "The next node in the queue should be null after one add", 
            null, queue.first.next);

        queue.add(node_2_value);
        assertEquals(
            "The first node of the queue should be " + Integer.toString(node_1_value) + " after two adds", 
            node_1_value, (int)queue.first.data);
        assertEquals(
            "The last node of the queue should be " + Integer.toString(node_2_value) + " after two adds", 
            node_2_value, (int)queue.last.data);
        assertEquals(
            "The next node in the queue should be " + Integer.toString(node_2_value) + " after two adds", 
            node_2_value, (int)queue.first.next.data);
    }

    @Test public void testRemove() {
        queue.add(node_1_value);
        queue.add(node_2_value);

        final int remove_1 = queue.remove();
        assertEquals(
            "The first node of the queue should be " + Integer.toString(node_2_value) + " after one remove", 
            node_2_value, (int)queue.first.data);
        assertEquals(
            "The first remove() should return " + Integer.toString(node_1_value), 
            node_1_value, (int)remove_1);

        final int remove_2 = queue.remove();
        assertEquals(
            "The first node of the queue should be null after two removes", 
            null, queue.first);
        assertEquals(
            "The last node of the queue should be null after two removes", 
            null, queue.last);
        assertEquals(
            "The second remove() should return " + Integer.toString(node_2_value), 
            node_2_value, remove_2);
    }
}
