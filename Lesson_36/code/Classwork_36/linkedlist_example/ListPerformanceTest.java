package Classwork_36.linkedlist_example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ListPerformanceTest {

    private static final int N_NUMBERS = 500_000;
    private static final Random random = new Random();
    private static final int MIN = 10;
    private static final int MAX = 20;

    public static void main(String[] args) {

        List<Integer> list = new LinkedList<>();
        fillCollection(list);

        System.out.println("====================== for each loop =======================");
        long t1 = System.currentTimeMillis();
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }
        long t2 = System.currentTimeMillis();
        System.out.println("sum = " + sum);
        System.out.println("duration = " + (t2 - t1));

        System.out.println("====================== Iterator =======================");
        t1 = System.currentTimeMillis();
        sum = 0;
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        t2 = System.currentTimeMillis();
        System.out.println("sum = " + sum);
        System.out.println("duration = " + (t2 - t1));

        System.out.println("====================== for i loop =======================");
        t1 = System.currentTimeMillis();
        sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            System.out.println(sum);
        }
        t2 = System.currentTimeMillis();
        System.out.println("sum = " + sum);
        System.out.println("duration = " + (t2 - t1));

    }

    private static void fillCollection(List<Integer> list) {
        for (int i = 0; i < N_NUMBERS; i++) {
            list.add(random.nextInt(MIN, MAX));
        }
    }

    private static void printList(List<Integer> list) {
        for (Integer i : list) {
            System.out.print(i + "\t");
        }
        System.out.println();
        System.out.println("============================================ ");
    }

}
