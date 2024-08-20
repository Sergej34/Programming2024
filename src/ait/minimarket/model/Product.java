package ait.minimarket.model;
//Марафон: Объекты - Интерфейсы - Тесты - Имплементация
//Во всех класcах должен быть некий id (штрих-код, isbn и т.д.)
//Book - Library, найти несколько книг по автору
//Computer (Laptop, SmartPhone) - Shop, найти компьютеры со скидкой на BlackFriday
//Product (Food, MeatFood, MilkFood) - Supermarket, искать продукты по сроку годности
// (срок задается строкой вида yyyy-MM-dd), общая стоимость всех товаров, средняя стоимость, ...
//Pets (Cat, Dog) - Hotel, выручка от отеля, найти всех животных по породе, ...
//Student, Aspirant, Professor - High school - средний балл, выбрать студентов со средним баллом от и до, ..
import java.util.Objects;

public abstract class Product {

    public static final int BARCODE_LENGTH = 20;  // final - изменить это значение нельзя

    private final String barcode;  // type String
    private final String name;
    private double price;

    public Product(String barcode, String name, double price) {
        this.barcode = checkBarcode(barcode);
        this.name = name;
        this.price = price;
    }

    private String checkBarcode(String barcode) {
        if (barcode.length() == BARCODE_LENGTH) {
            return barcode;
        }
        return "-1"; // wrong barcode
    }

    public String getBarcode() {
        return barcode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // (equals) он должен решать вопрос идентификации нашего объекта по бар коду
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Product product)) return false;
        return Objects.equals(barcode, product.barcode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(barcode);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product{");
        sb.append("barcode='").append(barcode).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
