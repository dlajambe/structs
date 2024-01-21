package com.davidlajambe.structs;

import java.lang.Math;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinHeapTest {
    MinHeap heap = new MinHeap();

    public boolean isOrdered(final MinHeap heap) {
        int childIdx = 1;
        while (childIdx < heap.nodes.size()) {
            final int parentValue = heap.getParentValue(childIdx);
            final int childValue = heap.nodes.get(childIdx);
            if (parentValue > childValue) {
                return false;
            }
            childIdx++;
        }
        return true;
    }

    @Test public void testInsert() {
        final int minValue = 0;
        final int maxValue = 9;
        for (int i = minValue; i <= maxValue; i++) {
            this.heap.insert(i);
            assertTrue("insert() should preserve minimum ordering", isOrdered(heap));
        }

        this.heap.insert(minValue - 1);
        assertTrue("Inserting a new minimum should preserve minimum ordering", isOrdered(heap));

        this.heap.insert((int)Math.floor((double)(minValue + maxValue)/2));
        assertTrue("Inserting a middle value preserve minimum ordering", isOrdered(heap));
    }
}
