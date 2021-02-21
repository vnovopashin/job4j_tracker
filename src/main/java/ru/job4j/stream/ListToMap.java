package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс реализует конвертацию списка в карту
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 */
public class ListToMap {
    /**
     * В данном методе поле surname является ключом,
     * а в качестве значения используется объект Student,
     * чтобы избежать java.lang.IllegalStateException в случае одинаковых ключей,
     * используется перегруженный метод toMap,
     * в котором определено в случае коллизии (student1, student2) -> student1)
     * оставляем student1
     *
     * @param students принимает список студентов
     * @return возвращает карту студентов
     */
    public Map<String, Student> collect(List<Student> students) {
        return students.stream()
                .distinct()
                .collect(
                        Collectors.toMap(Student::getSurname,
                                student -> student,
                                (student1, student2) -> student1));
    }
}
