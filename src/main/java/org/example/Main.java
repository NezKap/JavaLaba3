package org.example;

/**
 * Класс для демонстрации методов класса PerformanceComparison,
 * показывающий работу основного метода comparePerformance, а
 * также метода setOperationCount
 * @author Егор
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        PerformanceComparison comparator = new PerformanceComparison();
        comparator.setOperationCount(10000);
        comparator.comparePerformance();
    }
}