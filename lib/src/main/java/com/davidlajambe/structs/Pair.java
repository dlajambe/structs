package com.davidlajambe.structs;

public class Pair<T1, T2> {
    T1 value1 = null;
    T2 value2 = null;

    Pair(T1 value1, T2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }
}
