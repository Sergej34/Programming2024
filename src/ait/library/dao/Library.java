package ait.library.dao;

import ait.library.model.Book;

//Задание 1. Book - Library: сделать полностью пример по аналогии с Employee - Company. Методы:
//добавить книгу
//обновить данные о книге
//найти книгу по isbn
//удалить книгу
//найти все книги по автору
//найти книги с годом издания от и до
//Имплементация + тест
//Прислать решение ссылкой на GitHub
public interface Library {
    // only abstract methods for Library and children
    boolean addBook(Book book); // boolean - отвечает за то, что удалось добавить или нет

    Book removeBook(long isbn);

    Book findBook(long isbn);

    void printBook();   // ничего не возвращает

    int quantityBook();
    //обновить данные о книге
    Book updateBook(Book book);

    Book[] findBookByAuthor(String author);

    Book[] findBookByYear(double min, double max);

}
