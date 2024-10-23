package HomeWork_46.memory.utils;
// Задача 1. В классе MemoryService реализовать метод getMaxAvailableMemory, определяющий размер максимально
// возможного к созданию массива целых чисел. Проверяем решение через готовый тест.

public class MemoryService {

    // максимальный объём доступной памяти
    public static int getMaxAvailableMemory() {
        int size = Integer.MAX_VALUE;   // Начинаем с максимального возможного значения для массива.
        while (true) {   // Цикл будет работать до тех пор, пока не найдём подходящий размер массива.
            try {
                int[] arr = new int[size];  // Пытаемся создать массив размером size.
                break;  // Если массив создан успешно, выходим из цикла.
            } catch (OutOfMemoryError e) {  // Ловим ошибку, если размер массива слишком велик для выделенной памяти.
                size /= 2;  // Если возникает ошибка, уменьшаем размер массива в 2 раза.

            }
        }

        return size;

    }

}

