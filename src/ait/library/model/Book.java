package ait.library.model;

import java.util.Objects;

// Создать класс Book с полями:
// long isbn, String title, String author, int yearOfPublishing.
// Проверить ISBN на корректное количество цифр = 13.
public class Book implements Comparable<Book> {

    public static final int ISBN_LENGTH = 13; // Константа - // final - изменить это значение нельзя

    private String title;
    private String author;
    private int yearOfPublishing;
    private long isbn;

    public Book(String title, String author, int yearOfPublishing, long isbn) {
        this.title = title;
        this.author = author;
        this.yearOfPublishing = yearOfPublishing;
        this.isbn = checkIsbn(isbn);
    }

    private long checkIsbn(long isbn) {
        if (countDigits(isbn) == ISBN_LENGTH) {
            return isbn;
        }
        return -1;
    }

    private int countDigits(long isbn) {
        int count = 0;
        do {
            count++;
            isbn = isbn / 10;
        } while (isbn != 0);
        return count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Book{");
        sb.append("title='").append(title).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", yearOfPublishing=").append(yearOfPublishing);
        sb.append(", isbn=").append(isbn);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Book book)) return false;
        return isbn == book.isbn;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }


    @Override
    public int compareTo(Book o) {
        return 0;
    }
}
