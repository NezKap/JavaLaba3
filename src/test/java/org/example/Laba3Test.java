package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс для проведения unit-тестов
 * для проверки корректной работы
 * методов класса PerformanceComparison
 * @author Егор
 * @version 1.0
 */

public class Laba3Test {

    /**
     * Тестирование работы конструктора компаратора
     */

    @Test
    void createComparator() {
        PerformanceComparison firstComparator = new PerformanceComparison();
        assertEquals(1000, firstComparator.getOperationCount());
        PerformanceComparison secondComparator = new PerformanceComparison(1200);
        assertEquals(1200, secondComparator.getOperationCount());
    }

    /**
     * Тестирование получения числа операций в данном компараторе
     */

    @Test
    void gettingOperationCount() {
        PerformanceComparison comparator = new PerformanceComparison();
        comparator.setOperationCount(10000);
        assertEquals(10000, comparator.getOperationCount());
    }

    /**
     * Тестирование изменения числа операций в данном компараторе
     */

    @Test
    void settingOperationCount() {
        PerformanceComparison comparator = new PerformanceComparison();
        comparator.setOperationCount(2000);
        assertEquals(2000, comparator.getOperationCount());
    }
}
