package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerfomanceComparison {
    private static final int operationCount = 1000;
    private long testAddToTheBeginning(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount; i++) {
            list.add(0, i);
        }
        return System.nanoTime() - startTime;
    }
    private long testAddToTheEnd(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        return System.nanoTime() - startTime;
    }
    private long testAddInTheMiddle(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount; i++) {
            list.add(list.size() / 2, i);
        }
        return System.nanoTime() - startTime;
    }
}
