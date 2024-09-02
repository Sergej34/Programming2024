package homework_31.ait.time.test;


import homework_31.ait.time.utils.DateOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DateOperationTest {

    @Test
    void getAge() {
        Assertions.assertEquals(63, DateOperation.getAge("12/04/1961"));
        assertEquals(62, DateOperation.getAge("1961-11-28"));
    }

    @Test
    void sortStringDates() {
        String[] dates = {"2000-12-01", "10/12/2000", "1970-08-12", "2010-10-05"};
        String[] actual = DateOperation.sortStringDates(dates);
        String[] expected = {"1970-08-12", "2000-12-01", "10/12/2000", "2010-10-05"};
        assertArrayEquals(expected, actual);
    }


    @Test
    void testSort(){
        String[] dates = {"2000-12-01", "10/12/2000", "1970-08-12", "2010-10-05"};
        Arrays.sort(dates);
        printArray(dates);

    }

    @Test
    void testArrayStringToLocalDate(){
        String[] dates = {"2000-12-01", "10/12/2000", "1970-08-12", "2010-10-05"};
        LocalDate[] res = DateOperation.mapStringsToDates(dates);
        printArray(res);
    }

    private void printArray(Object[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("-----------------------------------------");
    }

}
