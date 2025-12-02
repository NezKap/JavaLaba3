package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Класс, позволяющий сравнить производительность
 * различных методов коллекций ArrayList и LinkedList
 * <p>
 * Сравниваются методы добавления элементов в начало,
 * середину и конец списков, получение элементов списков,
 * удаление элементов из начала, середины и конца списков,
 * поиска элементов в списке, использования итераторов в
 * обоих списках, а также полной очистки обоих списков.
 * </p>
 * @author Егор
 * @version 1.0
 */

public class PerformanceComparison {
    private int operationCount;

    /**
     * Конструктор класса компаратора по умолчанию
     * с установлением значения числа операций равным 1000
     */

    public PerformanceComparison() {
        operationCount = 1000;
    }

    /**
     * Конструктор класса компаратора по умолчанию
     * с установлением значения числа операций равным _operationCount
     * @param _operationCount число операций
     */

    public PerformanceComparison(int _operationCount) {
        operationCount = _operationCount;
    }

    /**
     * Вычисление времени добавления элементов в начало списка
     * @param list список, внутрь которого будут добавляться элементы
     * @return время в миллисекундах, за которое выполнился рассматриваемый метод
     */

    private double testAddToTheBeginning(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount; i++) {
            list.add(0, i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    /**
     * Вычисление времени добавления элементов в конец списка
     * @param list список, внутрь которого будут добавляться элементы
     * @return время в миллисекундах, за которое выполнился рассматриваемый метод
     */

    private double testAddToTheEnd(List<Integer> list) {
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    /**
     * Вычисление времени добавления элементов в середину списка
     * @param list список, внутрь которого будут добавляться элементы
     * @return время в миллисекундах, за которое выполнился рассматриваемый метод
     */

    private double testAddInTheMiddle(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount; i++) {
            list.add(list.size() / 2, i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    /**
     * Вычисление времени получения элементов списка по индексу
     * @param list список, на котором будет использован данный метод
     * @return время в миллисекундах, за которое выполнился рассматриваемый метод
     */

    private double testGetElem(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount; i++) {
            list.get(i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    /**
     * Вычисление времени удаления элементов из начала списка
     * @param list список, из начала которого будут удаляться элементы
     * @return время в миллисекундах, за которое выполнился рассматриваемый метод
     */

    private double testRemoveAtTheBeginning(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount; i++) {
            list.remove(0);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    /**
     * Вычисление времени удаления элементов из конца списка
     * @param list список, из конца которого будут удаляться элементы
     * @return время в миллисекундах, за которое выполнился рассматриваемый метод
     */

    private double testRemoveAtTheEnd(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = operationCount - 1; i >= 0; i--) {
            list.remove(i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    /**
     * Вычисление времени удаления элементов из середины списка
     * @param list список, из середины которого будут удаляться элементы
     * @return время в миллисекундах, за которое выполнился рассматриваемый метод
     */

    private double testRemoveInTheMiddle(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount; i++) {
            if (!list.isEmpty()) {
                list.remove(list.size() / 2);
            }
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    /**
     * Вычисление времени поиска элемента в списке
     * @param list список, внутри которого будет осуществляться поиск элементов
     * @return время в миллисекундах, за которое выполнился рассматриваемый метод
     */

    private double testContains(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        for (int i = 0; i < operationCount; i++) {
            list.contains(i);
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    /**
     * Вычисление времени использования итератора в списке,
     * причём суммирование во время прохождения по списку
     * осуществляется для предотвращения оптимизации компилятором
     * @param list список, внутри которого будет осуществляться использование итератора
     * @return время в миллисекундах, за которое выполнился рассматриваемый метод
     */

    private double testIteration(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        int sum = 0;
        for (Integer elem : list) {
            sum += elem;
        }
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    /**
     * Вычисление времени полной очистки списка
     * @param list список, который будет полностью очищен
     * @return время в миллисекундах, за которое выполнился рассматриваемый метод
     */

    private double testClear(List<Integer> list) {
        for (int i = 0; i < operationCount; i++) {
            list.add(i);
        }
        long startTime = System.nanoTime();
        list.clear();
        return (System.nanoTime() - startTime) / 1000000.0;
    }

    /**
     * Получение числа операций в данном компараторе
     * @return число операций в компараторе
     */

    public int getOperationCount() {
        return operationCount;
    }

    /**
     * Установление числа операций в данном компараторе
     * @param _operationCount число операций, которое необходимо установить в этом компараторе
     */

    public void setOperationCount(int _operationCount) {
        operationCount = _operationCount;
    }

    /**
     * Осуществление сравнения производительности коллекций
     * ArrayList и LinkedList, а также вывод полученных
     * результатов в виде таблицы
     */

    public void comparePerfomance() {
        System.out.println("Сравнение производительности ArrayList и LinkedList");
        System.out.printf("| %-30s | %-19s | %-14s | %-15s |\n", "Метод", "Количество операций",
                "ArrayList (мс)", "LinkedList (мс)");
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();
        System.out.printf("| %-30s | %-19s | %-14s | %-15s |\n", "add в начало", operationCount,
                testAddToTheBeginning(arrayList), testAddToTheBeginning(linkedList));
        System.out.printf("| %-30s | %-19s | %-14s | %-15s |\n", "add в конец", operationCount,
                testAddToTheEnd(arrayList), testAddToTheEnd(linkedList));
        System.out.printf("| %-30s | %-19s | %-14s | %-15s |\n", "add в середину", operationCount,
                testAddInTheMiddle(arrayList), testAddInTheMiddle(linkedList));
        System.out.printf("| %-30s | %-19s | %-14s | %-15s |\n", "get", operationCount, testGetElem(arrayList),
                testGetElem(linkedList));
        System.out.printf("| %-30s | %-19s | %-14s | %-15s |\n", "remove из начала", operationCount,
                testRemoveAtTheBeginning(arrayList), testRemoveAtTheBeginning(linkedList));
        System.out.printf("| %-30s | %-19s | %-14s | %-15s |\n", "remove из конца", operationCount,
                testRemoveAtTheEnd(arrayList), testRemoveAtTheEnd(linkedList));
        System.out.printf("| %-30s | %-19s | %-14s | %-15s |\n", "remove из середины", operationCount,
                testRemoveInTheMiddle(arrayList), testRemoveInTheMiddle(linkedList));
        System.out.printf("| %-30s | %-19s | %-14s | %-15s |\n", "contains", operationCount,
                testContains(arrayList), testContains(linkedList));
        System.out.printf("| %-30s | %-19s | %-14s | %-15s |\n", "iteration", operationCount,
                testIteration(arrayList), testIteration(linkedList));
        System.out.printf("| %-30s | %-19s | %-14s | %-15s |\n", "clear", operationCount,
                testClear(arrayList), testClear(linkedList));
    }
}
