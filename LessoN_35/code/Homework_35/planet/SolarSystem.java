package Homework_35.planet;
//Задача 2. Занести планеты солнечной системы в список, содержащий:
//наименование;
//расстояние до Солнца;
//массу;
//количество спутников.
//Вывести список планет отсортированный по:
//порядку расположения в солнечной системе;
//алфавиту;
//массе;
//количеству спутников.
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SolarSystem {
    public static void main(String[] args) {

        List<Planet> planets = new ArrayList<>();
        planets.add(new Planet("Mercury", 57.91, 3.3011e23,0));
        planets.add(new Planet("Uranus", 2_870.99, 8.6810e25, 27 ));
        planets.add(new Planet("Mars", 227.94, 6.4171e23, 2));
        planets.add(new Planet("Neptune",4_498.25, 1.02413e26, 14));
        planets.add(new Planet("Saturn", 1_429.40,5.6834e26, 83));
        planets.add(new Planet("Earth", 149.60,5.97237e24, 1));
        planets.add(new Planet("Venus", 108.21, 4.8675e24, 0));
        planets.add(new Planet("Jupiter", 778.57, 1.8982e27, 95));


        System.out.println("Planets order location in the solar system");
        planets.forEach(System.out::println);
        System.out.println();

        // сортировка по алфавиту
        planets.sort(Comparator.comparing(Planet::getName));
        System.out.println("Планеты по алфавиту");
        planets.forEach(System.out::println);
        System.out.println();
        // сортировка по порядку расположения солнечной системе
        planets.sort(Comparator.comparing(Planet::getDistanceFromSun));
        System.out.println("Сортировка по порядку расположения солнечной системе");
        planets.forEach(System.out::println);
        System.out.println();
        // сортировка по массе
        planets.sort(Comparator.comparing(Planet::getMass));
        System.out.println("Сортировка по массе");
        planets.forEach(System.out::println);
        System.out.println();
        // сортировка по спутникам
        planets.sort(Comparator.comparing(Planet::getNumberOfMoons));
        System.out.println("Сортировка по спутникам");
        planets.forEach(System.out::println);
        System.out.println();

    }
}
