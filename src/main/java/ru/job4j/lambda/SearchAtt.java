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
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getSize() > 100;
            }
        };

        return filter(list, predicate);
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(list, predicate);
    }

    /**
     * Универсальный метод фильтрации
     *
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
