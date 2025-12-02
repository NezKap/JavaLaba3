package org.example;

public class Main {
    public static void main(String[] args) {
        PerformanceComparison comparator = new PerformanceComparison();
        comparator.setOperationCount(10000);
        comparator.comparePerfomance();
    }
}