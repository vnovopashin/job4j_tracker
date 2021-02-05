package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Func {
    /**
     * Метод реализует подсчет функции в диапазоне
     *
     * @param start начало диапазона
     * @param end   конец диапазона
     * @param func функция для расчета (линейная, квадратичная, показательная)
     * @return возвращает список с посчитанными значениями
     */
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {

        List<Double> rsl = new ArrayList<>();
        for (int i = start; i < end; i++) {

            rsl.add(func.apply((double) i));
        }
        return rsl;
    }
}
