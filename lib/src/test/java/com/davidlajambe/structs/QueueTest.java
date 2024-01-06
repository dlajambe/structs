package com.davidlajambe.structs;

import org.junit.Test;
import static org.junit.Assert.*;

public class QueueTest {
    @Test public void add() {
        Queue<Integer> queue = new Queue<Integer>();

        int node_1_value = 0;
        queue.add(node_1_value);
        assertTrue(
            "The first node of the queue should be " + Integer.toString(node_1_value) + " after one add", 
            node_1_value == queue.first.data);
        assertTrue(
            "The last node of the queue should be " + Integer.toString(node_1_value) + " after one add", 
            node_1_value == queue.last.data);
        assertTrue(
            "The next node in the queue should be null after one add", 
            queue.first.next == null);

        int node_2_value = 1;
        queue.add(node_2_value);
        assertTrue(
            "The first node of the queue should be " + Integer.toString(node_1_value) + " after two adds", 
            node_1_value == queue.first.data);
        assertTrue(
            "The last node of the queue should be " + Integer.toString(node_2_value) + " after two adds", 
            node_2_value == queue.last.data);
        assertTrue(
            "The next node in the queue should be " + Integer.toString(node_2_value) + " after two adds", 
            node_2_value == queue.first.next.data);
    }

    @Test public void remove() {
        Queue<Integer> queue = new Queue<Integer>();

        int node_1_value = 0;
        int node_2_value = 1;
        queue.add(node_1_value);
        queue.add(node_2_value);

        int remove_1 = queue.remove();
        assertTrue(
            "The first node of the queue should be " + Integer.toString(node_2_value) + " after one remove", 
            node_2_value == queue.first.data);
        assertTrue(
            "The first remove() should return " + Integer.toString(node_1_value), 
            node_1_value == remove_1);

        int remove_2 = queue.remove();
        assertTrue(
            "The first node of the queue should be null after two removes", 
            null == queue.first);
        assertTrue(
            "The last node of the queue should be null after two removes", 
            null == queue.last);
        assertTrue(
            "The second remove() should return " + Integer.toString(node_2_value), 
            node_2_value == remove_2);
    }
}
