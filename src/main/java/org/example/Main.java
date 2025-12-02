package org.example;

public class Main {
    public static void main(String[] args) {
        PerfomanceComparison comparator = new PerfomanceComparison();
        comparator.setOperationCount(10000);
        comparator.comparePerfomance();
    }
}