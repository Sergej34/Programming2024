package HomeWork.tourist;

import java.util.Arrays;

// Задача 1.
//Турагентство специализируется на странах Средиземноморья -
// Испания, Франция, Италия, Греция, Турция, Тунис.
// Имеется таблица с данными о поездках клиентов в течение
// 2020-2023 годов в перечисленные страны.
// Каждый из клиентов посетил от одной до 3 стран, причем
// некоторые страны по 2 и более раз.
//Необходимо ответить на вопросы:
//Какие страны наиболее популярны?
//Кто из клиентов посетил наибольшее количество стран?
public class Tourists {
    private String name;
    String[] countries;
    private int date;

    public Tourists(String name, int date, String... countries) {
        this.name = name;
        this.countries = countries;
        this.date = date;
    }

    public int getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String[] getCountries() {
        return countries;
    }

    @Override
    public String toString() {
        return "Tourists{" +
                "name='" + name + '\'' +
                ", countries=" + Arrays.toString(countries) +
                ", date=" + date +
                '}';
    }
}
