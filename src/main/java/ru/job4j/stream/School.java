package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Класс позволяет отфильтровать список с использованием Stream API
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 */
public class School {
    /**
     * Метод позволяет отфильтровать по заданному условию и вернуть отфильтрованный список
     *
     * @param students Список который требуется отфильтровать
     * @param predict  условие по которому происходит фильтрация
     * @return возвращает отфильтрованный по условию список
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}
