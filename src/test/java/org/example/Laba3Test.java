package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Laba3Test {

    @Test
    void createComparator() {
        PerfomanceComparison comparator = new PerfomanceComparison();
        assertEquals(1000, comparator.getOperationCount());
    }

    @Test
    void gettingOperationCount() {
        PerfomanceComparison comparator = new PerfomanceComparison();
        assertEquals(1000, comparator.getOperationCount());
        comparator.setOperationCount(10000);
        assertEquals(10000, comparator.getOperationCount());
    }

    @Test
    void settingOperationCount() {
        PerfomanceComparison comparator = new PerfomanceComparison();
        comparator.setOperationCount(2000);
        assertEquals(2000, comparator.getOperationCount());
    }
}
