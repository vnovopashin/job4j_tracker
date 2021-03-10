package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Класс Analyze получает статистику по аттестатам.
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 */

public class Analyze {

    /**
     * Метод вычисляет общий средний балл.
     *
     * @param stream принимает поток Pupil (учеников)
     * @return возаращает средний балл
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * Метод вычисляет средний балл ученика по его предметам.
     *
     * @param stream принимает поток Pupil (учеников)
     * @return Возвращает список из объекта Tuple (имя ученика и средний балл)
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(), x.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * Метод вычисляет средний балл по всем предметам для каждого ученика.
     *
     * @param stream принимает поток Pupil (учеников)
     * @return Возвращает список из объекта Tuple (название предмета и средний балл).
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .sorted(Comparator.comparing(Tuple::getName).reversed())
                .collect(Collectors.toList());
    }

    /**
     * Метод вычисляет лучшего ученика.
     * Лучшим считается ученик с наибольшим баллом по всем предметам.
     *
     * @param stream принимает поток Pupil (учеников)
     * @return возвращает лучшего ученика.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(x -> new Tuple(x.getName(), x.getSubjects().stream()
                .mapToInt(Subject::getScore)
                .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    /**
     * Метод вычисляет предмет с наибольшим баллом для всех студентов.
     *
     * @param stream принимает поток Pupil (учеников)
     * @return Возвращает объект Tuple (имя предмета,
     * сумма баллов каждого ученика по этому предмету)
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(x -> new Tuple(x.getKey(), x.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}
