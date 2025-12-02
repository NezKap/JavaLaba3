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
    public int getOperationCount() {
        return operationCount;
    }
    public void comparePerfomance() {
        System.out.println("Сравнение производительности ArrayList и LinkedList");
        System.out.printf("| %-30s | | %-15s | | %-15s | | %-30s |\n", "Метод", "Количество операций",
                "ArrayList (наносекунды)", "LinkedList (наносекунды");
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        System.out.printf("| %-30s | | %-15s | | %-15s | | %-30s |\n", "add в начало", operationCount,
                testAddToTheBeginning(arrayList), testAddToTheBeginning(linkedList));
        System.out.printf("| %-30s | | %-15s | | %-15s | | %-30s |\n", "add в конец", operationCount,
                testAddToTheEnd(arrayList), testAddToTheEnd(linkedList));
        System.out.printf("| %-30s | | %-15s | | %-15s | | %-30s |\n", "add в середину", operationCount,
                testAddInTheMiddle(arrayList), testAddInTheMiddle(linkedList));
        System.out.printf("| %-30s | | %-15s | | %-15s | | %-30s |\n", "get", operationCount, testGetElem(arrayList),
                testGetElem(linkedList));
        System.out.printf("| %-30s | | %-15s | | %-15s | | %-30s |\n", "remove из начала", operationCount,
                testRemoveAtTheBeginning(arrayList), testRemoveAtTheBeginning(linkedList));
        System.out.printf("| %-30s | | %-15s | | %-15s | | %-30s |\n", "remove из конца", operationCount,
                testRemoveAtTheEnd(arrayList), testRemoveAtTheEnd(linkedList));
        System.out.printf("| %-30s | | %-15s | | %-15s | | %-30s |\n", "remove из середины", operationCount / 10,
                testRemoveInTheMiddle(arrayList), testRemoveInTheMiddle(linkedList));
        System.out.printf("| %-30s | | %-15s | | %-15s | | %-30s |\n", "contains", operationCount,
                testContains(arrayList), testContains(linkedList));
        System.out.printf("| %-30s | | %-15s | | %-15s | | %-30s |\n", "iteration", operationCount,
                testIteration(arrayList), testIteration(linkedList));
        System.out.printf("| %-30s | | %-15s | | %-15s | | %-30s |\n", "clear", operationCount,
                testClear(arrayList), testClear(linkedList));
    }
}
