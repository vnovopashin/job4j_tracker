package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * Класс производит фильтрацию списка Attachment,
 * посредством функционального интерфейса
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 */
public class SearchAtt {
    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    /**
     * Универсальный метод фильтрации
     * @param list      список котрый требуется отфильтровать
     * @param predicate условие по которому будет произведена фильтрация
     * @return возвращает отфильтрованный по условию список
     */
    public static List<Attachment> filter(List<Attachment> list, Predicate<Attachment> predicate) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (predicate.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }
}
