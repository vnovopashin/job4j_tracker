package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс реализует фильтрацию учеников
 *
 * @author Novopashin Vasiliy
 * @since 1.0
 */
public class StudentLevel {
    /**
     * Метод фильтрует учеников по проходному баллу исключая null
     *
     * @param students список учеников для фильтрации
     * @param bound    проходной бал
     * @return возвращает отфильтрованный список учеников
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(Stream::ofNullable)
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
