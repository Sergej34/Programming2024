package HomeWork.tourist;
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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TravelAgencyAppl {
    public static void main(String[] args) {

        List<Tourists> touristsList = fillListTourists();
        printTourists(touristsList);
        System.out.println("======================= Most popular countries ======================");
        printMostPopularCountries(touristsList);
        printMostPopularCountriesByTourists(touristsList);
    }

    private static void printMostPopularCountriesByTourists(List<Tourists> touristsList) {
        Map<Integer, List<Tourists>> popularCountriesByTourists = touristsList.stream()
                .collect(Collectors.groupingBy(t-> t.getCountries().length));

        Integer max = popularCountriesByTourists.keySet().stream()
                .max(Integer::compareTo).orElse(0);

        System.out.println(popularCountriesByTourists);
        System.out.println("Max = " + max);
        System.out.println("Tourists visit the largest number of countries - >");

        for (Integer key : popularCountriesByTourists.keySet()){
            System.out.println("Q-ty of countries: " + key + ", tourists: " + popularCountriesByTourists.get(key));
        }

    }

    private static void printMostPopularCountries(List<Tourists> touristsList) {
        System.out.println("Print all countries");
        // вытащим все популярные странны
        Iterable<String> countries = touristsList.stream()
                .map(Tourists::getCountries)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        // убираем дубликаты
        System.out.println("List of countries:");
        StreamSupport.stream(countries.spliterator(),false)
                .distinct()
                .forEach(System.out::println);
        // сколько туристов посещают каждую страну
        System.out.println("========================= Grouping by Tourists ==============================");
        Map<String,Long> counFrequency = touristsList.stream()
//  Метод map() преобразует каждый элемент потока (объект Tourists) в массив стран
//  (или список стран), которые посетил этот турист.
//  Метод getCountries() должен возвращать массив или список строк
//  (например, ["Spain", "France"] для одного туриста).
                .map(Tourists::getCountries)
// Метод flatMap() преобразует каждый массив стран в поток отдельных строк
// (каждая строка представляет собой название страны).
//  Arrays::stream превращает массив стран в поток, и flatMap()
//  "расплющивает" массивы в единый поток стран. "Spain", "France", "Italy", "Spain"
                .flatMap(Arrays::stream)
// collect() собирает элементы потока в коллекцию (в данном случае — в карту Map).
// groupingBy(t -> t) группирует элементы потока (в данном случае страны) по их значению.
// То есть каждая уникальная страна становится ключом в карте, а все одинаковые страны
// объединяются в одну группу.
//   Collectors.counting() подсчитывает, сколько раз каждая страна встречается в потоке.
                .collect(Collectors.groupingBy(t->t, Collectors.counting()));
        System.out.println(counFrequency);

    }

    private static void printTourists(List<Tourists> touristsList) {
        for (Tourists t : touristsList){
            System.out.println(t);
        }

    }

    private static List<Tourists> fillListTourists() {
        return List.of(
        //        Испания, Франция, Италия, Греция, Турция, Тунис.
                new Tourists("Anna", 2020, "Spain","Italy", "Tunisia", "Turkey"),
                new Tourists("Michael", 2023, "Greek","Turkey", "France", "Tunisia","Spain"),
                new Tourists("Arnold",2021,"Greek", "Italy", "Spain"),
                new Tourists("Robert",2022,"Turkey", "Spain"),
                new Tourists("Isabel",2020, "France", "Italy", "Spain", "Turkey","Greek")

        );
    }
}
