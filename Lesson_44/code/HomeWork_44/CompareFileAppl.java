package HomeWork_44;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// Задание 1. В классе CompareFileAppl реализовать логику сравнения
// двух файлов в методе main. Имена файлов принимать через массив args.
// Два файла считаем одинаковыми, если у них одинаковая длина,
// и на тех же позициях стоят те же байты. Результат должен быть
// выведен на консоль в виде сообщения.
public class CompareFileAppl {
    public static void main(String[] args) {
        //  Программа ожидает два аргумента командной строки, которые представляют собой имена файлов.
        if (args.length < 2) {
            System.out.println("Please provide two file names as arguments.");
            return;
        }
        // Создаём String файлы / Инициализация переменных
        String file1 = args[0];
        String file2 = args[1];
        FileInputStream fis1 = null;
        FileInputStream fis2 = null;

        // Проверка длины файлов и чтение содержимого
        // Создаются объекты File для указанных файлов
        // try - попытаться, попробуйте
        try {
            File f1 = new File(file1);
            File f2 = new File(file2);

            // Сначала проверяем длину фалов
            if (f1.length() != f2.length()) {
                System.out.println("Files are different: different sizes.");
                return;
            }
            // Если длина файлов одинаковая, открываются потоки для чтения файлов с помощью FileInputStream
            fis1 = new FileInputStream(f1);
            fis2 = new FileInputStream(f2);

            // Сравнение файлов побайтно
            int byte1, byte2;
            while ((byte1 = fis1.read()) != -1 && (byte2 = fis2.read()) != -1) {
                if (byte1 != byte2) {
                    System.out.println("Files are different.");
                    return;
                }

            }
            System.out.println("File are identical.");

            // Обработка исключений
            // catch - уловители ошибок
            // Этот блок перехватывает исключения, связанные с операциями ввода-вывода
            // (например, если файл не найден или возникает ошибка при чтении)
        } catch (IOException e) {
            System.out.println("Error occurred: " + e.getMessage());

            // Закрытие потоков в блоке finally
        } finally {
            try {
                if (fis1 != null) fis1.close();
                if (fis2 != null) fis2.close();
            } catch (IOException e) {
                System.out.println("Error closing file streams.");
            }
        }
    }
}
