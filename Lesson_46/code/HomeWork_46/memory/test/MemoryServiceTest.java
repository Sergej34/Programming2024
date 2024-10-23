package HomeWork_46.memory.test;



import homework_46.memory.utils.MemoryService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
// Задача 1. В классе MemoryService реализовать метод getMaxAvailableMemory, определяющий размер максимально
// возможного к созданию массива целых чисел. Проверяем решение через готовый тест.
public class MemoryServiceTest {

    int[] arr;

    @Test
    void test() {
        int maxMemory = MemoryService.getMaxAvailableMemory(); // Получаем максимальный доступный размер массива.
        boolean flag;
        try {
            arr = new int[maxMemory]; // Пытаемся создать массив максимального размера.
            flag = true;    // Если удалось - флаг true.
        } catch (OutOfMemoryError e) {
            flag = false;   // Если ошибка - флаг false.
        }
        assertTrue(flag);   // Проверяем, что флаг true, т.е массив был создан успешно.

        try {
            arr = new int[maxMemory + 1];   // Пытаемся создать массив больше на 1 элемент.
            flag = true;    // Если удалось - флаг true (но этого быть не должно).
        } catch (OutOfMemoryError e) {
            flag = false;   // Если ошибка - флаг false (что ожидаемо).
        }
        assertFalse(flag);  // Проверяем, что флаг false, т.е массив такого размера уже не создается.
    }
}
