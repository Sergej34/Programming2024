package Homework_40;
import java.util.HashMap;
import java.util.Map;

public class CountryContinent {
    public static void main(String[] args) {
        // Создаем карту стран и континентов
        Map<String, String> countries = new HashMap<>();

        countries.put("Russia", "Europe");
        countries.put("Germany", "Europe");
        countries.put("Brazil", "South America");
        countries.put("Argentina", "South America");
        countries.put("Canada", "North America");
        countries.put("USA", "North America");
        countries.put("China", "Asia");
        countries.put("India", "Asia");
        countries.put("Egypt", "Africa");
        countries.put("South Africa", "Africa");
        countries.put("Australia", "Australia");
        countries.put("New Zealand", "Australia");
        countries.put("Japan", "Asia");
        countries.put("Mexico", "North America");
        countries.put("France", "Europe");
        countries.put("Kenya", "Africa");
        countries.put("Nigeria", "Africa");
        countries.put("Chile", "South America");
        countries.put("Saudi Arabia", "Asia");
        countries.put("Italy", "Europe");

        // Подсчитываем количество стран на каждом континенте с добавлением проверки if
        Map<String, Integer> continentCount = new HashMap<>();

        for (String continent : countries.values()) {
            // Проверяем, есть ли этот континент в карте
            if (continentCount.containsKey(continent)) {
                // Если континент уже существует, увеличиваем счетчик стран на этом континенте
                int currentCount = continentCount.get(continent);
                continentCount.put(continent, currentCount + 1);
            } else {
                // Если континента еще нет, добавляем его с начальным значением 1
                continentCount.put(continent, 1);
            }
        }

        // Выводим результаты, только если на континенте больше 3 стран
        for (Map.Entry<String, Integer> entry : continentCount.entrySet()) {
            if (entry.getValue() > 3) { // Проверяем условие if
                System.out.println("Континент: " + entry.getKey() + ", Количество стран: " + entry.getValue());
            } else {
                System.out.println("Континент: " + entry.getKey() + " имеет меньше 4 стран.");
            }
        }
    }
}
