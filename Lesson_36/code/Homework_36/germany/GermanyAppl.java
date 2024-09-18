package Homework_36.germany;

import java.util.LinkedList;
import java.util.List;

// Задача 1. В классе GermanyAppl (main) cоздать LinkedList, содержащий города - столицы земель Германии.
// Опробовать на нем методы, которые доступны для класса LinkedList. Добавить Гамбург в середину списка, в начало списка.
public class GermanyAppl {
    public static void main(String[] args) {

        List<String> capitals = new LinkedList<>();

        capitals.add("Berlin");
        capitals.add("München");
        capitals.add("Stuttgart");
        capitals.add("Dresden");
        capitals.add("Hanover");
        capitals.add("Düsseldorf");

        System.out.println("Первоначальный список столиц: " + capitals);

        capitals.add(3, "Hamburg");
        System.out.println("После добавления Гамбурга в середину: " + capitals);

        capitals.addFirst("Hamburg");
        System.out.println("После добавления Гамбурга в начало: " + capitals);

        String firstCity = capitals.getFirst(); // Получить первый элемент
        String lastCity = capitals.getLast(); // Получить последний элемент
        String removedCity = capitals.remove(2); // Удалить город по индексу

        System.out.println("Первый город в списке: " + firstCity);
        System.out.println("Последний город в списке: " + lastCity);
        System.out.println("Город удалённый с индекса 2: " + removedCity);
        System.out.println("Текущий список столиц: " + capitals);



    }

}
