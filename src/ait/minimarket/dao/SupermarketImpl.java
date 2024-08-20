package ait.minimarket.dao;

import ait.minimarket.model.Product;

public class SupermarketImpl implements Supermarket {

    private int branch;
    private Product[] products;
    private int quantity;


    public SupermarketImpl(Product[] products, int branch, int capacity) {
        products = new Product[capacity];
        this.branch = branch;

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

    @Override
    public Product updateProduct(Product product) {
        // нужен fori добегаем до quantity для поиска бар кода
        for (int i = 0; i < quantity; i++) {
            // ищем с помощью if getBarcode продукт которого нужно обновить (не barcode обновлять) если совпали ищем по массиву
            if (products[i].getBarcode() == product.getBarcode()) {
                // В массиве имевшего заменяем на того кого прислали который в barcode совпали
                products[i] = product;
                // возвращаем новый продукт обновлённый
                return product;
            }
        }
        // если не нашлось возвращаем ноль null
        return null;
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

    @Override
    public void printProduct() {
        for (int i = 0; i < quantity; i++) {
            System.out.println(products[i]);

        }

    }

    @Override
    public int quantity() {
        return quantity;
    }
}

