package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * В данном классе фильтруется список с использованием Stream API,
 * в результате фильтрации получаем новый список содержащий только положительные числа
 */
public class StreamList {

    List<Integer> list = List.of(1, 2, -2, 0, -10, 8);
    List<Integer> positiveNumbers = list.stream()
            .filter(n -> n >= 0)
            .collect(Collectors.toList());
}
