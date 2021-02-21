package ru.job4j.stream;

public class BookRunner {
    public static void main(String[] args) {
        Book book = new Book.Builder().buildAuthor("Кей Хорстманн")
                .buildTitle("Java" + '\u2122' + " библиотека профессионала Том 1. Основы")
                .buildEdition(10)
                .buildPublisher("Вильямс")
                .buildYearOfPublishing(2018)
                .buildIsbn(978_5_8459_2084_3L)
                .buildAvailability(true)
                .build();
        System.out.println(book);
    }
}
