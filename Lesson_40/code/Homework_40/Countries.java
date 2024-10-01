package Homework_40;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//Задание 1. Соберите в структуру Map порядка 20 стран, по несколько страны из разных континентов Земли.
// Подсчитайте количество стран на континентах из полученного списка.
public class Countries {
    public static void main(String[] args) {

        Map<String, String> countries = new TreeMap<>();
        countries.put("France", "Europa");
        countries.put("Germany", "Europa");
        countries.put("Italy", "Europa");
        countries.put("Spain", "Europa");
        countries.put("Japan", "Asia");
        countries.put("India", "Asia");
        countries.put("China", "Asia");
        countries.put("South Korea", "Asia");
        countries.put("Nigeria", "Africa");
        countries.put("Egypt", "Africa");
        countries.put("Kenya", "Africa");
        countries.put("South Africa", "Africa");
        countries.put("USA", "North America");
        countries.put("Canada", "North America");
        countries.put("Mexico", "North America");
        countries.put("Cuba", "North America");
        countries.put("Brazil", "South America");
        countries.put("Argentina", "South America");
        countries.put("Columbia", "South America");
        countries.put("Chile", "South America");

        System.out.println(countries.size());

        // Подсчитываем количество стран нак каждом континенте
        Map<String, Integer> continentCount = new HashMap<>();
        for (String continent : countries.values()) {
            // Проверяем есть ли этот континент в карте
            if (continentCount.containsKey(continent)) {
                // Если континент уже существует, увеличиваем счётчик стран на этом континенте
                int currentCount = continentCount.get(continent);
                continentCount.put(continent, currentCount + 1);
            } else {
                // Если континента ещё нет, добавляем его с начальным значением 1
                continentCount.put(continent, 1);
            }
        }
        // Выводим точное количество стран на каждом континенте
        for (Map.Entry<String, Integer> entry : continentCount.entrySet()) {
            System.out.println("Континент: " + entry.getKey() + ", Количество стран: " + entry.getValue());
        }
    }
}
