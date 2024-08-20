package homework_28;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class CityTest {

    City[] cities;

    @BeforeEach
    void setUp() {

        cities = new City[]{
                new City("Bremen", 577000, 326, 1150),
                new City("Hamburg", 1787280, 755, 1200),
                new City("Osnabrück", 164748, 118.8, 1050),
                new City("Oldenburg", 168210, 103, 900),
                new City("Berlin", 3645000, 898.1, 980),
        };
    }

    public void printArray(City[] cities) {
        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i]);
        }
        System.out.println("====================================================");
    }

    @Test
    void testSortCityByPopulation() {
        printArray(cities);
        Arrays.sort(cities);
        printArray(cities);
    }

    @Test
    void testCitySortByName() {
        printArray(cities);
        Arrays.sort(cities, (city1, city2) -> city1.getName().compareTo(city2.getName()));
        printArray(cities);

    }

    @Test
    void testCitySortByAge() {
        printArray(cities);
        Arrays.sort(cities, (city1, city2) -> {
            int res = city1.getAge() - city2.getAge();
            return res != 0 ? res : city1.getPopulation() - city2.getPopulation();
        });
        printArray(cities);

    }

    @Test
    void testCitySortByArea() {
        printArray(cities);
        Arrays.sort(cities, (city1, city2) -> Double.compare(city1.getArea(), city2.getArea()));
        printArray(cities);

        Comparator<City> comparatorByAreaAndByName = new Comparator<City>() {
            @Override
            public int compare(City city1, City city2) {
                int res = Double.compare(city1.getArea(), city2.getArea());
                return res != 0 ? res : city1.getName().compareTo(city2.getName());
            }
        };
        Arrays.sort(cities, comparatorByAreaAndByName);
        printArray(cities);
    }

    @Test
    void testArrayBinarySearch(){
        printArray(cities);
        Arrays.sort(cities, (city1, city2) -> city1.getName().compareTo(city2.getName()));
        printArray(cities);
        City pattern = new City("Berlin", 0, 0,0);
        int index = Arrays.binarySearch(cities, pattern, (city1, city2) -> city1.getName().compareTo(city2.getName()));
        System.out.println(index);
        printArray(cities);
    }



}