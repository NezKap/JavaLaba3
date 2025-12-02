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
    private long testGetElem(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount; i++) {
            list.get(i);
        }
        return System.nanoTime() - startTime;
    }
    private long testRemoveAtTheBeginning(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount; i++) {
            list.remove(0);
        }
        return System.nanoTime() - startTime;
    }
    private long testRemoveAtTheEnd(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = operationCount - 1; i >= 0; i--) {
            list.remove(i);
        }
        return System.nanoTime() - startTime;
    }
    private long testRemoveInTheMiddle(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount / 10; i++) {
            if (!list.isEmpty()) {
                list.remove(list.size() / 2);
            }
        }
        return System.nanoTime() - startTime;
    }
    private long testContains(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount; i++) {
            list.contains(i);
        }
        return System.nanoTime() - startTime;
    }
    private long testIteration(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        int sum = 0;
        for (Integer elem : list) {
            sum += elem;
        }
        return System.nanoTime() - startTime;
    }
    private long testClear(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        list.clear();
        return System.nanoTime() - startTime;
    }
}
