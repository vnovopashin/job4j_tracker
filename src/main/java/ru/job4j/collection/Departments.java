package ru.job4j.collection;

import java.util.*;

/**
 * Класс реализует упрощенный справочник подразделений.
 * @author Vasiliy Novopashin
 * @version 1.0
 */
public class Departments {

    /**
     * Метод на вход принимает список подразделений,
     * если подразделение отсутсвует то метод добавит их.
     * В качестве промежуточного хранения используется множество LinkedHashSet,
     * которое позволяет устранить дубликаты,
     * при этом данные будут отсортированы в порядке добавления
     * @param deps список подразделений
     * @return заполненный список подразделений
     */
    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new LinkedHashSet<>();
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start = start.isEmpty() ? el : start + ("/" + el);
                tmp.add(start);
            }
        }
        return new ArrayList<>(tmp);
    }

    /**
     * Метод на вход принимает массив кодов подразделений и сортирует его по возрастанию,
     * сохранияя иерархическую структуру.
     * @param orgs коды подразделений
     */
    public static void sortAsc(List<String> orgs) {
        orgs.sort(Comparator.naturalOrder());
    }

    /**
     * Метод на вход принимает массив кодов подразделений и сортирует его по убыванию,
     * сохранияя иерархическую структуру.
     * @param orgs коды подразделений
     */
    public static void sortDesc(List<String> orgs) {
        orgs.sort(new DepDescComp());
    }
}
