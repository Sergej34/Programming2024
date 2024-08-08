package ait.library.test;
// Задание 1. Book - Library: сделать полностью пример по аналогии
// с Employee - Company. Методы:
//добавить книгу
//обновить данные о книге
//найти книгу по isbn
//удалить книгу
//найти все книги по автору
//найти книги с годом издания от и до
//Имплементация + тест
//Прислать решение ссылкой на GitHub


import ait.library.dao.Library;
import ait.library.dao.LibraryImpl;
import ait.library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class LibraryImplTest {

    // создаётся объект на базе интерфейса и даём название
    Library library;
    // создаётся массив и даём название
    Book[] books;


    @BeforeEach
    void setUp() {
        library = new LibraryImpl(5);
        books = new Book[6];
        books[0] = new Book("Clear code", "Robert Martin",2006, 1_111_111_111_111L);
        books[1] = new Book("Title 1", "Author 1",2006, 1_111_111_111_112L);
        books[2] = new Book("Title 2", "Author 1",2006, 1_111_111_111_113L);
        books[3] = new Book("Title 3", "Author 2", 2006, 1_111_111_111_114L);
        books[4] = new Book("Title 4", "Author 2", 2006, 1_111_111_111_115L);
        books[5] = new Book("Title 5", "Author 3", 2007,1_111_111_111_116L);

        for (int i = 0; i < books.length; i++) {
            library.addBook(books[i]);
            System.out.println(books[i]);//
        }
        System.out.println("--------------------------");
    }

    @Test
    void addBook() {
        assertFalse(library.addBook(null));
        assertFalse(library.addBook(books[0]));
        Book book = new Book("Война и мир","Лев Толстой",1952, 1_111_111_111_117L);
        assertTrue(library.addBook(book));
        assertEquals(7, library.quantityBook());
        book = new Book("Люди на болоте", "Иван Мележ", 1990, 1_111_111_111_118L);
        assertFalse(library.addBook(book));
    }

    @Test
    void removeBook() {
        Book bookVictim = library.removeBook(1_111_111_111_111L);
        assertEquals(books[0],bookVictim);
        assertEquals(4, library.quantityBook());
        assertNull(library.removeBook(1_111_111_111_111L));

    }

    @Test
    void findBook() {
        assertEquals(books[2],library.findBook(1_111_111_111_113L));
        assertNull(library.findBook(1_111_111_111_117L));

    }

    @Test
    void printBook() {
        library.printBook();
    }

    @Test
    void quantityBook() {
        assertEquals(5, library.quantityBook());
    }

    @Test
    void updateBook(){
        Book book = new Book("Title 1", "Author 1",2006, 1_111_111_111_112L);
        assertEquals(books[1], library.updateBook(book));
        book = new Book("Title 6", "Author 6", 2018, 1_111_111_111_116L);
        assertNull(library.updateBook(book));
        System.out.println(book);
    }
}