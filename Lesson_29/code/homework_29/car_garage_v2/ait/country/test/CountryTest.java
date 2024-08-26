package homework_29.car_garage_v2.ait.country.test;

import homework_29.car_garage_v2.ait.country.model.Country;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    Country[] countries;

    @BeforeEach
    void setUp() {
        countries = new Country[6];
        countries[0] = new Country("USA", 345_426_571);
        countries[1] = new Country("Germany", 84_552_242);
        countries[2] = new Country("Russia", 144_820_423);
        countries[3] = new Country("Brazil", 217_637_297);
        countries[4] = new Country("Argentina", 46_057_866);
        countries[5] = new Country("France", 66_548_530);
    }

    private void printArray(Object[] arr, String title) {
        System.out.println("========================== " + title + " ===========================");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    @Test
    void testComparable() {
        printArray(countries, "Ordinary array");
        Arrays.sort(countries);
        printArray(countries, "Natural order");
        Country pattern = new Country(null, 100_000_000);
        int index = Arrays.binarySearch(countries, pattern);
        System.out.println(index);
    }

    @Test
    void testComparator() {
        Comparator<Country> comparator = (country1, country2) -> country1.getName().compareTo(country2.getName());
        Arrays.sort(countries, comparator);
        printArray(countries, "Sort by name");
        Country pattern = new Country("Argentina", 0);
        int index = Arrays.binarySearch(countries, pattern, comparator);
        System.out.println(index);
    }

    @Test
    void testArrayCopy() {
        Comparator<Country> comparator = Comparator.nullsLast((country1, country2) -> country1.getName().compareTo(country2.getName()));
        Country[] countryCopy = Arrays.copyOf(countries, countries.length * 2);
        printArray(countryCopy, "countryCopy before sort");
        Arrays.sort(countryCopy, comparator);
        printArray(countryCopy, "countryCopy after sort");

        Country pattern = new Country("Spain", 0);
        int index = Arrays.binarySearch(countryCopy, 0, countries.length, pattern, comparator);
        System.out.println(index);
    }

    @Test
    void testKeepSorting(){
        Arrays.sort(countries);
        printArray(countries,"Natural order");
        Country country = new Country("Spain",47_473_373);
        // увеличим массив до 7 элементов
        Country[] countryCopy = Arrays.copyOf(countries, countries.length + 1);
        printArray(countryCopy, "test");
        int index = Arrays.binarySearch(countryCopy,0, countryCopy.length - 1, country);
        index = index >= 0 ? index : -index - 1;
        System.arraycopy(countryCopy, index, countryCopy, index + 1, countryCopy.length - index - 1); // делаем место для массива
        countryCopy[index] = country;
        countries = countryCopy; // переопределяем ссылку на массив
        printArray(countryCopy, "Natural order after add new Country");
    }

    @Test
    void testSystemArrayCopy(){
        Country[] countryCopy = new Country[countries.length + 2];
        System.arraycopy(countries, 1, countryCopy, 2, 4);// ставим в новый массив соо 2-й позиции 4 элемента из старого массива
        printArray(countries,"Original array");
        printArray(countryCopy, "New and copy of range");
    }

    @Test
    void testCopyOfRange(){
        Country[] countryCopy = Arrays.copyOfRange(countries, 1, countries.length + 1);
        printArray(countries, "Original array");
        printArray(countryCopy, "Copy of range");
    }
}