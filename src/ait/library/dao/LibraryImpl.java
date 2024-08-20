package ait.library.dao;


import ait.library.model.Book;

import java.util.function.Predicate;

public class LibraryImpl implements Library {

    private Book[] books;       // array for objects
    private int size;       // current size of array

    public LibraryImpl(int capacity) {
        this.books = new Book[capacity];
        //this.size = 0;
    }

    @Override
    public boolean addBook(Book book) {
        if (book == null || size == books.length || findBook(book.getIsbn()) != null) {
            //System.out.println("The book is null is full or the book already exists");
            return false;
        }
        // в конец массива добавить новый элемент
        books[size] = book; // size - это индекс первого свободного места в массиве
        size++;
        return true;

    }


    @Override
    // remove book
    public Book removeBook(long isbn) {         // Book вернём из метода тип Book
        /*тип Book*/
        // victim - жертва
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) { // isbn который нам прислали на удаление
                Book victim = books[i]; // сохраняем
                // на место этой книги ставим последнюю
                books[i] = books[size - 1]; // ставим последнюю на место удаляемой
                books[size - 1] = null; // последнее место затираем
                size--; // уменьшился size текущий занятых ячеек массива
                return victim;
            }
        }
        return null;
    }

    @Override
    public Book findBook(long isbn) {//public Book findBook(long isbn) {  // Book это мы обозначаем тип объекта которого мы вернём
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == isbn) { // getIsbn нужно взять isbn что он равен тому isbn который пришёл на вход
                return books[i];
            }
        }
        return null;
    }


    @Override
    public void printBook() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }

    }

    @Override
    public int quantityBook() {
        return size;
    }

    @Override
    public Book updateBook(Book book) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn() == book.getIsbn()) {
                books[i] = book;
                return book;
            }
        }
        return null;

    }

    @Override
    public Book[] findBookByAuthor(String author) {
        return findBookByPredicate(book -> author.equals(book.getAuthor()));
    }

    @Override
    public Book[] findBookByYear(double min, double max) {
        return findBookByPredicate(book -> book.getYearOfPublishing() > min && book.getYearOfPublishing() < max);
    }

    private Book[] findBookByPredicate(Predicate<Book> predicate) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (predicate.test(books[i])) {
                count++;
            }
        }
        Book[] res = new Book[count];
        for (int i = 0, j = 0; j < res.length; i++) {
            if (predicate.test(books[i])) {
                res[j++] = books[i];
            }
        }
        return res;
    }

}
