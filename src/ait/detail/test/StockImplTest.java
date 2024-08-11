package ait.detail.test;

import ait.detail.dao.Stock;
import ait.detail.dao.StockImpl;
import ait.detail.model.Detail;
import ait.detail.model.Gear;
import ait.detail.model.Lever;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StockImplTest {

    Stock stock;
    Detail[] details;

    @BeforeEach
    void setUp() {

        stock = new StockImpl(5);
        details = new Detail[6];
        details[0] = new Gear(1L, 10, "steal", "Bosh", 2.0, 12, 6);
        details[1] = new Gear(2L, 10, "steal", "Bosh", 2.0, 24, 8);
        details[2] = new Lever(3L, 100, "steal", "Bosh", 3.0, 12);
        details[3] = new Lever(4L, 100, "steal", "Bosh", 3.0, 12);

        for (int i = 0; i < details.length; i++) {
            stock.addDetail(details[i]);
        }
    }

    @Test
    void addDetail() {
        assertFalse(stock.addDetail(details[1]));// добавление дубликата
        assertFalse(stock.addDetail(null));// добавление null
        Detail detail = new Gear(5L, 10, "steal", "Bosh", 2.0, 24, 12);
        assertTrue(stock.addDetail(detail));// добавление новой детали
        assertEquals(5, stock.quantity());// проверка количества деталей на складе
        // Теперь склад полон, добавление новой детали должно вернуть false
        detail = new Gear(6L, 10, "steal", "Bosh", 2.0, 24, 12);
        assertFalse(stock.addDetail(detail));// добавление, когда склад уже полон

    }

    @Test
    void findByBarCode() {
        assertEquals(details[0], stock.findByBarCode(1L));
        assertEquals(details[2], stock.findByBarCode(3L));
        assertNull(stock.findByBarCode(6L)); // "поиск несуществующего баркода" / ПРОВЕРКА НА null

    }

    @Test
    void updateDetail() {
        Detail detail = new Gear(2L, 10, "steal", "Bosh2", 2.0, 24, 14);
        assertEquals(details[1], stock.updateDetail(detail));
        detail = new Lever(5L, 100, "steal", "Bosh", 3.0, 12);
        assertNull(stock.updateDetail(detail));
        System.out.println(detail);
    }

    @Test
    void deleteDetail() {
        Detail deletedDetail = stock.deleteDetail(1L);
        assertNotNull(deletedDetail);//Этот шаг проверяет, что удаленная деталь (deletedDetail) не является null и была действительно удалена по идентификатору 1L
        assertEquals(details[0], deletedDetail);//Этот шаг сравнивает удаленную деталь (deletedDetail) с предполагаемой деталью (details[0])
        assertNull(stock.findByBarCode(1L));//Здесь проверяется, что после удаления детали с идентификатором 1L, она больше не может быть найдена в коллекции stock (метод findByBarCode должен вернуть null).
        assertEquals(3, stock.quantity());//Этот шаг проверяет, что количество деталей в stock после удаления одной из них стало равным 3.
        assertNull(stock.deleteDetail(6L)); // удаление несуществующей детали
        assertEquals(3, stock.quantity()); // количество деталей после неудачной попытки удаления
    }

    @Test
    void printStock() {
        stock.printStock();
    }

}
