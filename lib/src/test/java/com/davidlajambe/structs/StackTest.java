package com.davidlajambe.structs;

import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {

    @Test public void push() {
        Stack<Integer> stack = new Stack<Integer>();

        int node_1_value = 0;
        stack.push(node_1_value);
        assertTrue(
            "The top node of the stack should be " + Integer.toString(node_1_value) + " after one push", 
            node_1_value == stack.top.data);
        assertTrue(
            "The next node in the stack should be null after one push", 
            stack.top.next == null);

        int node_2_value = 1;
        stack.push(node_2_value);
        assertTrue(
            "The top node of the stack should be " + Integer.toString(node_2_value) + " after two pushes", 
            node_2_value == stack.top.data);
        assertTrue(
            "The next node in the stack should be " + Integer.toString(node_1_value) + " after two pushes", 
            node_1_value == stack.top.next.data);
    }

    @Test public void pop() {
        Stack<Integer> stack = new Stack<Integer>();

        int node_1_value = 0;
        int node_2_value = 1;
        stack.push(node_1_value);
        stack.push(node_2_value);

        int pop_1 = stack.pop();
        assertTrue(
            "The top node of the stack should be " + Integer.toString(node_1_value) + " after one pop", 
            node_1_value == stack.top.data);
        assertTrue(
            "The first pop() should return " + Integer.toString(node_2_value), 
            node_2_value == pop_1);

        int pop_2 = stack.pop();
        assertTrue(
            "The top node of the stack should be null after two pops", 
            null == stack.top);
        assertTrue(
            "The second pop() should return " + Integer.toString(node_1_value), 
            node_1_value == pop_2);
    }
}
