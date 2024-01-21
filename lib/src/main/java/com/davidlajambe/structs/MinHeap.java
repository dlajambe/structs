package com.davidlajambe.structs;

import java.util.ArrayList;
import java.lang.Math;

public class MinHeap {
    private static final int DEFAULT_CAPACITY = 1000;
    ArrayList<Integer> nodes;

    MinHeap() {
        this(DEFAULT_CAPACITY);
    }

    MinHeap(final int capacity) {
        this.nodes = new ArrayList<Integer>(capacity);
    }


    int getLeftChildIdx(final int parentIdx) {
        return parentIdx * 2 + 1;
    }

    int getLeftChildValue(final int parentIdx) {
        return this.nodes.get(this.getLeftChildIdx(parentIdx));
    }

    int getRightChildIdx(final int parentIdx) {
        return parentIdx * 2 + 2;
    }

    int getRightChildValue(final int parentIdx) {
        return this.nodes.get(this.getRightChildIdx(parentIdx));
    }

    int getParentIdx(final int childIdx) {
        return (int)Math.floor(((double)childIdx - 1)/2);
    }

    int getParentValue(final int childIdx) {
        return this.nodes.get(this.getParentIdx(childIdx));
    }

    void insert(final int node) {
        // First, the node is added to the end of the tree to maintain completeness (the first fundamental requirement
        // of a MinHeap)
        nodes.add(node);


        // Next, the node is "bubbled up" by repeatedly swapping it with its immediate parent if the parent's value is
        // larger. This ensures that children are always greater than their parents (the second fundamental requirement
        // of a MinHeap)
        int childIdx = this.nodes.size() - 1;
        int parentIdx = this.getParentIdx(childIdx);
        while (parentIdx >= 0) {
            final int parentValue = nodes.get(parentIdx);
            final int childValue = nodes.get(childIdx);
            if (childValue < parentValue) {
                this.nodes.set(parentIdx, childValue);
                this.nodes.set(childIdx, parentValue);
                childIdx = parentIdx;
                parentIdx = this.getParentIdx(childIdx);
            } else {
                break;
            }
        }
    }

    void extract_min() {

    }
}
