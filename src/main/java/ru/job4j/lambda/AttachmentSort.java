package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Данный класс реализует сортировку объектов Attachment по полю size и полю name используя анонимные классы
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 */
public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Attachment left = (Attachment) o1;
                Attachment right = (Attachment) o2;
                return left.getSize() - right.getSize();
            }
        };
        attachments.sort(comparator);
        System.out.println(attachments);

        Comparator<Attachment> nameComparator = new Comparator<>() {
            @Override
            public int compare(Attachment a1, Attachment a2) {
                return a1.getName().compareTo(a2.getName());
            }
        };

        attachments.sort(nameComparator);
        System.out.println(attachments);
    }
}
