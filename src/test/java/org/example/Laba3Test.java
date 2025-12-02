package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Laba3Test {

    @Test
    void createComparator() {
        PerformanceComparison firstComparator = new PerformanceComparison();
        assertEquals(1000, firstComparator.getOperationCount());
        PerformanceComparison secondComparator = new PerformanceComparison(1200);
        assertEquals(1200, secondComparator.getOperationCount());
    }

    @Test
    void gettingOperationCount() {
        PerformanceComparison comparator = new PerformanceComparison();
        assertEquals(1000, comparator.getOperationCount());
        comparator.setOperationCount(10000);
        assertEquals(10000, comparator.getOperationCount());
    }

    @Test
    void settingOperationCount() {
        PerformanceComparison comparator = new PerformanceComparison();
        comparator.setOperationCount(2000);
        assertEquals(2000, comparator.getOperationCount());
    }
}
