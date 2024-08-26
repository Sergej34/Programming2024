package ait.minimarket.controller;
//Задание 1. Coздать класс Product с полями: private final String barcode; (проверка, что он содержит 20 символов!)
// private final String name; private double price; Конструктор, геттеры для полей barcode, name. Сеттер для поля price. toString
//Создать класс Food, расширяющий класс Product с полем: int energy;
//Создать класс Minimarket с полями: private int branch; (филиал) private Product[] products; private int quantity;
//В классе Minimarket создайте конструктор, принимающий на вход номер филиала brunch и вместимость склада capacity.
//В классе Minimarket создайте методы: boolean addProduct(Product product) void printProducts()
// Product findProduct(long barcode) Product removeProduct(long barcode) Product updateProduct(long barcode, double price)(*)
//Создайте класс MinimarketAppl, в котором создайте объект miniMarket на основе класса Minimarket с номером филиала 1001 и capacity 5.
//Наполните miniMarket продуктами, опробуйте на них работу методов: findProduct removeProduct printProducts updateProduct (*)


import ait.minimarket.model.Product;

public class Minimarket {
    private int branch;
    private Product[] products;
    private int quantity;

    public Minimarket(int branch, int capacity) {
        this.branch = branch;
        products = new Product[capacity];
        quantity = 0;
    }

    public Minimarket(int branch, Product[] products, int quantity) {
        this.branch = branch;
        this.products = products;
        this.quantity = quantity;
    }

    public int getBranch() {
        return branch;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean addProduct(Product product) {
        if (product == null || quantity == products.length || findProduct(product.getBarcode()) != null) {
            return false;
        }
        products[quantity] = product;
        quantity++;
        return true;
    }

    public Product findProduct(String barcode) {
        for (int i = 0; i < quantity; i++) {
            if (products[i].getBarcode().equals(barcode)) {
                return products[i];
            }
        }
        return null;
    }

    public Product updateProduct(String barcode, double price) {
        Product product = findProduct(barcode);
        if (product == null) {
            return null;
        }
        product.setPrice(price);
        return product;
    }

    public Product removeProduct(String barcode) {
        for (int i = 0; i < quantity; i++) {
            if (products[i].getBarcode().equals(barcode)) {
                Product victim = products[i];
                products[i] = products[quantity - 1];
                products[quantity - 1] = null;
                quantity--;
                return victim;
            }
        }
        return null;
    }
}
