package classwork_28.soldier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Soldier1Test {

    Soldier1[] soldiers;

    @BeforeEach
    void setUp() {
        soldiers = new Soldier1[]{
                new Soldier1("John", 182, 82.3, 91),
                new Soldier1("Peter", 175, 77.1, 75),
                new Soldier1("Robin", 162, 55.1, 91),
                new Soldier1("Mary", 159, 55.1, 91),
                new Soldier1("Ann", 162, 55, 88),
        };
    }

    @Test
    void testSoldiersNaturalOrder() {
        printArray(soldiers);
        Arrays.sort(soldiers);
        //System.out.println(Arrays.toString(soldiers));
        printArray(soldiers);
    }

    @Test
    void testSortSoldiersByName() {
        printArray(soldiers);
        Arrays.sort(soldiers, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        printArray(soldiers);
    }

    @Test
    void testSortSoldiersByProfile() {
        printArray(soldiers);
        Arrays.sort(soldiers, (s1, s2) -> {
            // если два profile одинаковые получается 0
            // если res не равен нулю !=0 они не одинаковые profile
            // если она не работает то res !=0 и она работает getProfile а когда работает и равен нулю включается второе поле с getHeight
            // если res !=0 тогда включается сортировка по profile(продолжаем сортировать по profile)
            int res = -(s1.getProfile() - s2.getProfile()); // sort by profile
            // если res равен нулю тогда включается сортировка по высоте
            return res != 0 ? res : s1.getName().compareTo(s2.getName());
            //return res != 0 ? res : -s1.getHeight() + s2.getHeight();
            // если res !=0 то мы его таким оставляем

        });

        printArray(soldiers);
    }

    @Test
    void testSortSoldiersByWeight() {
        printArray(soldiers);
        Arrays.sort(soldiers, (s1, s2) -> Double.compare(s1.getWeight(), s2.getWeight()));
        printArray(soldiers);

        Comparator<Soldier1> comparatorByWeightAndByName = new Comparator<Soldier1>() {
            @Override
            public int compare(Soldier1 o1, Soldier1 o2) {
                // если два weight одинаковые получается 0
                // если res не равен нулю !=0 они не одинаковые weight
                // если res !=0 тогда включается сортировка по weight(продолжаем сортировать по weight)
                int res = Double.compare(o1.getWeight(), o2.getWeight()); // weight
                // если res равен нулю тогда включается сортировка по имине
                return res != 0 ? res : o1.getName().compareTo(o2.getName()); // name
            }
        };
        Arrays.sort(soldiers, comparatorByWeightAndByName);
        printArray(soldiers);

    }

    @Test
    void testArraysBinarySearch(){
        printArray(soldiers);
        Arrays.sort(soldiers, (s1, s2) -> s1.getProfile() - s2.getProfile());// отсортированный массив по profile
        // printArray(soldiers);
        Soldier1 pattern = new Soldier1(null, 0, 0, 88); // who is searching
              //pattern - шаблон образец
                    // binarySearch работает по отсортированному массиву
        int index = Arrays.binarySearch(soldiers, pattern, (s1, s2) -> s1.getProfile() - s2.getProfile()); // search
        System.out.println(index);
        printArray(soldiers);
    }
    //Метод Arrays.binarySearch не принимает лямбда-выражение напрямую.
    //Так что алгоритм такой:
    //Шаг 1. Сортируем массив с вызовом компаратора или заданием лямбда-выражения.
    //Шаг 2. Применяем метод Arrays.binarySearch, при этом
    // **Arrays.binarySearch должен использовать тот же компаратор,
    //при помощи которого массив был отсортирован.**


    public void printArray(Object[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("========================================================");
    }

    //sorting Integer objects
    @Test
    void testSortIntegerDesc() {
        Integer[] array = {-1, Integer.MIN_VALUE, Integer.MAX_VALUE}; // 3 numbers in a wrong order
        Integer[] expected = {Integer.MAX_VALUE, -1, Integer.MIN_VALUE}; // expecting order
        Arrays.sort(array, (n1, n2) -> Integer.compare(n2, n1)); // sort array
        assertArrayEquals(expected, array); // check result
    }

}