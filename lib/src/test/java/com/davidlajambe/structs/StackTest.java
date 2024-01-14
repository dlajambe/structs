package com.davidlajambe.structs;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    final Stack<Integer> stack = new Stack<Integer>();
    final int node_1_value = 0;
    final int node_2_value = 1;

    @Test public void testConstructor() {
        assertEquals("Stack should be empty after initialization", 0, stack.size());
    }

    @Test public void testPush() {
        stack.push(node_1_value);
        assertTrue(
            "The top node of the stack should be " + Integer.toString(node_1_value) + " after one push", 
            node_1_value == stack.top.data);
        assertTrue(
            "The next node in the stack should be null after one push", 
            stack.top.next == null);

        stack.push(node_2_value);
        assertTrue(
            "The top node of the stack should be " + Integer.toString(node_2_value) + " after two pushes", 
            node_2_value == stack.top.data);
        assertTrue(
            "The next node in the stack should be " + Integer.toString(node_1_value) + " after two pushes", 
            node_1_value == stack.top.next.data);
    }

    @Test public void testPop() {
        stack.push(node_1_value);
        stack.push(node_2_value);

        final int pop_1 = stack.pop();
        assertEquals(
            "The top node of the stack should be " + Integer.toString(node_1_value) + " after one pop", 
            node_1_value, (int)stack.top.data);
        assertEquals(
            "The first pop() should return " + Integer.toString(node_2_value), 
            node_2_value, pop_1);

        final int pop_2 = stack.pop();
        assertEquals(
            "The top node of the stack should be null after two pops", 
            null, stack.top);
        assertEquals(
            "The second pop() should return " + Integer.toString(node_1_value), 
            node_1_value, pop_2);
    }
}
