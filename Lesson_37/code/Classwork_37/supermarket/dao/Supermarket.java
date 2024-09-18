package Classwork_37.supermarket.dao;

import classwork_37.supermarket.model.Product;

public interface Supermarket {

    boolean addProduct(Product product);
    Product removeProduct(long barCode);
    Product findByBarcode(long barCode);
    Iterable<Product> findByCategory(String category);
    Iterable<Product> findByBrand(String brand);
    Iterable<Product> findProductsWithExpiredDate();
    int skuQuantity();
}
