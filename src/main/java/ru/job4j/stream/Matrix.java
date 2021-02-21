package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс реализует конвертацию двумерного массива в список
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 */
public class Matrix {
    /**
     * Метод принимает на вход двумерный массив и конвертирует в список
     *
     * @param array принимает двумерный массив
     * @return вовращает список
     */

    public List<Integer> collect(Integer[][] array) {
        return Stream.of(array)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }
}
