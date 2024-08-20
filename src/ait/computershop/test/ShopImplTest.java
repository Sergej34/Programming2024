package ait.computershop.test;

import ait.computershop.dao.Shop;
import ait.computershop.dao.ShopImpl;
import ait.computershop.model.Computer;
import ait.computershop.model.Laptop;
import ait.computershop.model.SmartPhone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopImplTest {

    // создаётся объект на базе интерфейса и даём название
    private Shop shop;
    // создаётся массив и даём название
    private Computer[] computers;

    @BeforeEach
    void setUp() {
        shop = new ShopImpl(7);
        computers = new Computer[7];
        computers[0] = new Laptop (25624599655L,"Core i7", 8, 512, "Asus", 1300,17,5.2, 20);
        computers[1] = new Laptop (21563545865L,"Core i5", 12, 512, "HP", 800,15.4,4.1, 24);
        computers[2] = new Laptop (21548622323L,"Core i9", 12, 512, "Asus", 1600,17,5.2, 16);
        computers[3] = new SmartPhone (256241365655L,"M2", 8, 1024, "Apple", 1200,17, 35);
        computers[4] = new SmartPhone (256245948555L,"M1", 8, 512, "Apple", 1000,15, 25);
        computers[5] = new SmartPhone (25624565655L,"M3", 8, 2048, "MacBook Pro", 5200,17, 15);
        computers[6] = new SmartPhone (25624558655L,"A3", 12, 64, "iPhone", 1400,25, 19);

        /*computers[0] = new Laptop (25624599655L,"Core i7", 8, 512, "Asus", 1200,17,5.2, 20);
        computers[1] = new Laptop (21563545865L,"Core i5", 8, 512, "Acer", 800, 15,4.1, 24);
        computers[2] = new Laptop (21548622323L,"Core i9", 8, 512, "HP", 1600, 20, 6.5, 28);
        computers[3] = new Laptop  (63265441527L,"M2", 16, 1024, "Apple", 3000, 14, 2.6, 10); // upper casting
        computers[4] = new Laptop  (13659245555L,"M1", 8, 512, "Apple", 2400, 12.1, 1.6, 12);
        computers[5] = new Laptop  (21369851522L,"M3", 32, 2048, "Apple MacBook Pro", 5200, 16, 3.6, 16);
        computers[6] = new SmartPhone(12459865136L,"A3", 12, 64, "iPhone", 1400, 12,5526665555666L);*/

        for (int i = 0; i < computers.length; i++) {
            shop.addComputer(computers[i]);
            System.out.println(computers[i]);

        }
        System.out.println("--------------------------------------");
    }

    @Test
    void addComputer() {
        assertFalse(shop.addComputer(null)); // добавление null
        assertFalse(shop.addComputer(computers[2])); // добавление дубликата
        Computer computers = new Laptop(22265997162L,"Core i7", 16, 1024, "Asus", 1650,17,5.6, 24);
        assertTrue(shop.addComputer(computers));// добавление нового компьютера
        assertEquals(4, shop.quantity());// проверка на количество компьютеров
        // Теперь склад полон, добавление новой детали должно вернуть false
       // computer = new Computer(21548232563L,"Core i7", 8, 256, "HP", 1200);
        assertFalse(shop.addComputer(computers));
    }

    @Test
    void findComputer() {
        assertEquals(computers[3], shop.findComputer(25624599655L));
        assertNull(shop.findComputer(63265446527L));
    }

    @Test
    void updateComputer() {
        Computer computer = new Laptop(21548622323L, "Core i9", 16, 1024, "Samsung", 2500, 17,5.2, 24);
        assertEquals(computers[2], shop.updateComputer(computer));
        System.out.println("-------------------------------------");
        System.out.println(computer);
        computer = new SmartPhone(25625698421166L, "Snap dragon", 16, 512, "Samsung", 1500, 25, 21569841362L);
        assertNull(shop.updateComputer(computer));
    }

    @Test
    void removeComputer() {
        Computer computerVictim = shop.removeComputer(256245948555L);
        assertEquals(computers[4],computerVictim);
        assertEquals(6, shop.quantity());
        assertNull(shop.removeComputer(256245948555L));
    }

    @Test
    void printComputer() {
        shop.printComputer();

    }

    @Test
    void quantity() {
        assertEquals(7, shop.quantity());
    }
}