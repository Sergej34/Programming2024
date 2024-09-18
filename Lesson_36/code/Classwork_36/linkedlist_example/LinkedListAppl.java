package Classwork_36.linkedlist_example;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LinkedListAppl {

    // заполнить список случайными целыми числами
    // проверить работу методов LinkedList
    private static final int N_NUMBERS = 10;
    private static final Random random = new Random();
    private static final int MIN = 10;
    private static final int MAX = 20;

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        fillCollection(list);
        printList(list);

        System.out.println("Size " + list.size());

        System.out.println(list.get(0));
        System.out.println(list.get(5));
        System.out.println(list.get(9));
        //System.out.println(list.get(10));
        System.out.println(list.indexOf(15));
        list.set(0, 5);
        list.add(0);
        list.set(10, 50);
        printList(list);

        // NB! Wrong way!
      /*  for (Integer num : list) {
            if (num.equals(15)) {
                list.remove(num);
            }
        }

        */
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            if (num.equals(15)) {
                iterator.remove();
            }
        }
        printList(list);
        Integer num = 50;
        list.remove(num);
        printList(list);
        list.remove(0);
        printList(list);

        // удаление по условию
        System.out.println("//////////////////////////////////////////////////////");
        list.removeIf(n -> n % 2 == 0);
        printList(list);
    } // end of main

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


} // end of class
