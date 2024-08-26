package ait.minimarket.test;

import ait.minimarket.dao.Supermarket;
import ait.minimarket.dao.SupermarketImpl;
import ait.minimarket.model.MeatFood;
import ait.minimarket.model.MilkFood;
import ait.minimarket.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketImplTest {
    Supermarket supermarket;
    Product[] products;


    @BeforeEach
    void setUp() {
        supermarket = new SupermarketImpl(5);// задаём capacity в SupermarketImpl
        products = new Product[5];// создаём массив на 5 мест
        products[0] = new MeatFood("2562459632233", "Meat", 5.69, "Pork", "USA", true, LocalDate.of(2024, 11, 26));
        products[1] = new MeatFood("1365974574598", "Meat", 5.69, "Beef", "USA", true, LocalDate.of(2024, 11, 26));
        products[2] = new MilkFood("3269874533622", "Milk", 2.89, "Bio milk", 3.8, 1.0, LocalDate.of(2024, 11, 15);
        products[3] = new MilkFood("3269984125456", "Cheese", 3.65, "Cheese", 45, 0.5, LocalDate.of(2024, 8, 23);
        products[4] = new MilkFood("2369854125899", "Joghurt", 2.56, "Lean Joghurt", 3.8, 0.3, LocalDate.of(2024, 8, 23);


        for (int i = 0; i < products.length; i++) {
            supermarket.addProduct(products[i]);
        }

    }

    @Test
    void addProduct() {
        assertFalse(supermarket.addProduct(null));// добавить нулевой продукт
        assertFalse(supermarket.addProduct(products[0]));// добавить существующий продукт
        Product product = new MeatFood("2635912662333", "Meat", 6.25, "Huhn", "Germany", true, LocalDate.of(2024, 11, 26));// создание нового продукта
        assertTrue(supermarket.addProduct(product));// добавление нового продукта на основе создания
    }

    @Test
    void findProduct() {
        assertEquals(products[2], supermarket.findProduct("3269874533622"));// поиск по массиву и по бар коду
        assertNull(supermarket.findProduct("26515998866156266"));
    }

    @Test
    void updateProduct() {
        // создание нового продукта с новым названием на обновление с существующим бар кодом
        Product product = new MeatFood("3269874533622", "Meat1", 6.36, "Pute", "Germany", true, LocalDate.of(2024, 11, 26));
        // ожидание обновлённого продукта по массиву и передача нового продукта созданного
        assertEquals(products[2], supermarket.updateProduct(product));
        // распечатка нового массива с новым продуктом
        supermarket.printProduct();
    }

    @Test
    void removeProduct() {
        // Создаём существующий продукт который хотим удалить по бар коду как жертву
        Product productVictim = supermarket.removeProduct("2369854125899");
        // assertEquals - значит что два значения равны индекс массива с текущим удаляющим по бар коду
        assertEquals(products[4], productVictim);
        // ожидание двух значений кол-во в capacity и quantity
        assertEquals(4, supermarket.quantity());
        // Ожидаем, что продукт не найден, поэтому должно быть null
        assertNull(supermarket.removeProduct("2369854125899"));
    }

    @Test
    void totalCost() {
        assertEquals(20.48, supermarket.totalCost());
    }

    @Test
    void averageCost() {
        assertEquals(4.096, supermarket.averageCost());
    }

    @Test
    void findOutOfDate() {
        Product[] expected = {products[3], products[4]};
        Product[] actual = supermarket.findOutOfDate(LocalDate.of(2024, 8, 23));
        assertEquals(expected, actual);
    }
    @Test
    void findProductByExpirationDate(){
        Product[] expected = {products[0], products[1]};
        //supermarket.printProduct();
        Product[] actual = supermarket.findProductByExpirationDate(LocalDate.of(2024, 11,26));
        assertArrayEquals(expected, actual);
    }


}