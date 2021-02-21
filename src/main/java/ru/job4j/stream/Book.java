package ru.job4j.stream;

/**
 * Класс реализует модель данных Book,
 * посредством шаблона Builder
 *
 * @author Vasiliy Novopashin
 * @version 1.0
 */
public class Book {

    private String author;
    private String title;
    private int edition;
    private String publisher;
    private int yearOfPublishing;
    private long isbn;
    private boolean availability;

    @Override
    public String toString() {
        return "Book{"
                + "author='" + author + '\''
                + ", title='" + title + '\''
                + ", edition=" + edition
                + ", publisher='" + publisher + '\''
                + ", yearOfPublishing=" + yearOfPublishing
                + ", isbn=" + isbn
                + ", availability=" + availability
                + '}';
    }

    static class Builder {

        private String author;
        private String title;
        private int edition;
        private String publisher;
        private int yearOfPublishing;
        private long isbn;
        private boolean availability;

        Builder buildAuthor(String author) {
            this.author = author;
            return this;
        }

        Builder buildTitle(String title) {
            this.title = title;
            return this;
        }

        Builder buildEdition(int edition) {
            this.edition = edition;
            return this;
        }

        Builder buildPublisher(String publisher) {
            this.publisher = publisher;
            return this;
        }

        Builder buildYearOfPublishing(int yearOfPublishing) {
            this.yearOfPublishing = yearOfPublishing;
            return this;
        }

        Builder buildIsbn(long isbn) {
            this.isbn = isbn;
            return this;
        }

        Builder buildAvailability(boolean availability) {
            this.availability = availability;
            return this;
        }

        Book build() {
            Book book = new Book();
            book.author = author;
            book.title = title;
            book.edition = edition;
            book.publisher = publisher;
            book.yearOfPublishing = yearOfPublishing;
            book.isbn = isbn;
            book.availability = availability;
            return book;
        }
    }
}