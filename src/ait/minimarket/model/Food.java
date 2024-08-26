package ait.minimarket.model;

import java.time.LocalDate;
import java.util.Objects;

public class Food extends Product {
    private LocalDate expDate;
    private final int energy;

    public Food(String barcode, String name, double price, LocalDate expDate, int energy) {
        super(barcode, name, price);
        this.expDate = expDate;
        this.energy = energy;
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Food food)) return false;
        if (!super.equals(object)) return false;
        return Objects.equals(expDate, food.expDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), expDate);
    }
    @Override
    public String toString(){
        return super.toString() + ", expDate: " + expDate;
    }
}
//Марафон: Объекты - Интерфейсы - Тесты - Имплементация
//Во всех класcах должен быть некий id (штрих-код, isbn и т.д.)
//Book - Library, найти несколько книг по автору
//Computer (Laptop, SmartPhone) - Shop, найти компьютеры со скидкой на BlackFriday
//Product (Food, MeatFood, MilkFood) - Supermarket, искать продукты по сроку годности (срок задается строкой вида yyyy-MM-dd), общая стоимость всех товаров, средняя стоимость, ...
//Pets (Cat, Dog) - Hotel, выручка от отеля, найти всех животных по породе, ...
//Student, Aspirant, Professor - High school - средний балл, выбрать студентов со средним баллом от и до, ...
//можно предложить свой вариант
//По методам - должны быть CRUD-операции: С - create R - read, find U - update (не обязательно) D - delete, remove
//Главное - не ШИРОКАЯ функциональность, а последовательность разработки от классов через интерфейс к тестированию и имплементации.
//Полный марафон - 5 проектов, полумарафон - 3 проекта.