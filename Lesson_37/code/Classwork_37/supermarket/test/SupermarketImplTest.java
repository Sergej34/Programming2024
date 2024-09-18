package Classwork_37.supermarket.test;

import classwork_37.supermarket.dao.Supermarket;
import classwork_37.supermarket.dao.SupermarketImpl;
import classwork_37.supermarket.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNull;

class SupermarketImplTest {

    Supermarket myMarket;
    Product[] products;
    LocalDate now = LocalDate.now();

    @BeforeEach
    void setUp() {
        myMarket = new SupermarketImpl();
        products = new Product[5];
        products[0] = new Product(111111, "White Bread", "Bread", "Kolosok", 6.5, now.plusDays(5));
        products[1] = new Product(222222, "ChokoMilk", "Dairy", "MilkLand", 13, now.minusDays(3));
        products[2] = new Product(333333, "Cheese Gauda", "Dairy", "Farmer", 22.5, now.plusDays(50));
        products[3] = new Product(444444, "Cheese Chedder", "Dairy", "MilkLand", 30, now.plusDays(85));
        products[4] = new Product(555555, "Sweet Buns", "Bread", "Kolosok", 18.3, now.minusDays(25));

        /*for (int i = 0; i < products.length; i++) {
            myMarket.addProduct(products[i]);
        }*/
        for (Product p : products) {
            myMarket.addProduct(p);
        }

    }

    @Test
    void addProduct() {
        assertFalse(myMarket.addProduct(null));
        assertFalse(myMarket.addProduct(products[3]));
        Product product1 = new Product(666666, "Sweet Buns", "Bread", "Kolosok", 18.3, now.minusDays(25));
        assertTrue(myMarket.addProduct(product1));
        assertEquals(6, myMarket.skuQuantity());
        Product product2 = new Product(666666, "Sweet Buns", "Bread", "Kolosok", 18.3, now.minusDays(25));
        assertFalse(myMarket.addProduct(product2)); // с одинаковым баркодом
        Product product3 = new Product(777777, "Sweet Buns", "Bread", "Kolosok", 18.3, now.minusDays(25));
        assertTrue(myMarket.addProduct(product3));
    }

    @Test
    void removeProduct() {
        assertEquals(products[1], myMarket.removeProduct(222222));
        assertEquals(4, myMarket.skuQuantity());
        assertNull(myMarket.removeProduct(222222)); // дважды не можем удалить
        // assertNull(myMarket.removeProduct(222222));
    }

    @Test
    void findByBarcode() {
        assertEquals(products[1], myMarket.findByBarcode(222222));
        assertNull(myMarket.findByBarcode(888888));
    }

    @Test
    void findByCategory() {
        ArrayList<Product> actual = (ArrayList<Product>) myMarket.findByCategory("Bread");
        int l = actual.size();
        Product[] productsActual = new Product[l];
        // переносим все значения из листа в массив
        int i = 0;
        for (Product p : actual) {
            productsActual[i] = p;
            i++;
        }
        Product[] expected = {products[0], products[4]};
        assertArrayEquals(productsActual, expected);
        printArray(expected);
    }

    @Test
    void findByBrand() {
        ArrayList<Product> actual = (ArrayList<Product>) myMarket.findByBrand("MilkLand");
        int l = actual.size();
        Product[] productsActual = new Product[l];
        int i = 0;
        for (Product p : actual){
            productsActual[i] = p;
            i++;
        }
        Product[] expected = {products[1], products[3]};
        assertArrayEquals(productsActual,expected);
        printArray(expected);

    }

    @Test
    void findProductsWithExpiredDate() {
        // Ожидаем, что метод вернет продукты с истекшим сроком годности
        ArrayList<Product> actual = (ArrayList<Product>) myMarket.findProductsWithExpiredDate();

        // Создаем массив ожидаемых просроченных продуктов (продукты с истекшим сроком годности)
        Product[] expected = {products[1], products[4]}; // ChokoMilk и Sweet Buns

        // Преобразуем список в массив для сравнения
        int l = actual.size();
        Product[] productsActual = new Product[l];
        int i = 0;
        for (Product p : actual) {
            productsActual[i] = p;
            i++;
        }

        // Проверяем, что фактический результат совпадает с ожидаемым
        assertArrayEquals(expected, productsActual);

        // Выводим результат для наглядности (необязательно)
        printArray(productsActual);
    }


    @Test
    void skuQuantity() {
        assertEquals(5, myMarket.skuQuantity());
    }

    private static void printArray(Object[] arr) {
        for (Object o : arr) {
            System.out.println(o);
        }
        System.out.println("--------------------------------------------------------------------------------");

    }
}