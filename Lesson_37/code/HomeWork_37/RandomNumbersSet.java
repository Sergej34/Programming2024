package HomeWork_37;


//Задача 2. Написать программу, которая:
//прочитает с клавиатуры количество чисел в коллекции (сколько будет чисел в коллекции),
//заполнит коллекцию случайными числами в интервале от 1 до 100,
//переносим коллекцию во множество (set);
//удалить из множества числа большие 10 и вывести полученные результаты на экран. Все числа целые.

import java.util.*;

public class RandomNumbersSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Чтение с клавиатуры количества чисел в коллекции
        System.out.print("Enter the number of elements in the collection: ");
        int count = scanner.nextInt();

        // 2. Заполнение коллекции случайными числами от 1 до 100
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            numbers.add(random.nextInt(100) + 1); // случайное число от 1 до 100
        }

        // Вывод исходной коллекции
        System.out.println("Original collection: " + numbers);

        // 3. Перенос коллекции в множество (Set)
        Set<Integer> numberSet = new HashSet<>(numbers);

        // 4. Удаление из множества чисел больше 10
        numberSet.removeIf(number -> number > 10);

        // Вывод результата на экран
        System.out.println("Set after removing numbers greater than 10: " + numberSet);

        scanner.close();
    }
}


