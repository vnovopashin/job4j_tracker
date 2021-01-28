package ru.job4j.lambda;

/**
 * Класс описывает модель даннных, которая будет использоваться для сортировки
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 */
public class Attachment {

    /**
     * Поле name хранит имя
     */
    private String name;

    /**
     * Поле size хранит размер
     */
    private int size;

    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}
