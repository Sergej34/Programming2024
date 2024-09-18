package Homework_35.computer;
////Задача 1. На основе класса Computer:
////создать собственный ArrayList;
////добавить в него не менее 6 элементов;
////отсортировать список по бренду;
////отсортировать список по размеру RAM, затем размеру SSD при равенстве RAM;
////подсчитать общий суммарный объем и среднее значение SSD.

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComputerStock {
    public static void main(String[] args) {

        List<Computer> computers = new ArrayList<>();
        computers.add(new Computer("Core i7", 8, 512, "Asus", 1200, 452_369_158_269_145L));
        computers.add(new Computer("Core i5", 16, 512, "Acer", 800, 632_541_265_321_584L));
        computers.add(new Computer("Core i9", 32, 512, "HP", 1200, 160_369_285_265_956L));
        computers.add(new Computer("Core i3", 8, 1024, "Apple", 3000, 145_684_269_812_645L));
        computers.add(new Computer("Ultra 9", 32, 1024, "Samsung", 3000, 145_684_232_812_652L));
        computers.add(new Computer("Core i9", 64, 1024, "Lenovo", 6600, 145_236_269_812_125L));

        System.out.println("---------------- Unsorted --------------------");
        print(computers);

        System.out.println("----------------- Sorted by brand --------------------");
        computers.sort(Computer::compareTo);// sorting
        print(computers);

        Comparator<Computer> comparator = new Comparator<Computer>() {
            @Override
            public int compare(Computer o1, Computer o2) {
                int res = o1.getRam() - o2.getRam();
                return res != 0 ? res : Integer.compare(o1.getSsd(), o2.getSsd());
            }
        };
        // sorting with comparator
        System.out.println("--------------------- Sorted by ram and then by ssd ---------------------------");
        computers.sort(comparator);
        print(computers);

        System.out.println("--------------------- Sorted by ram and then by ssd ---------------------------");
        computers.sort(Comparator.comparing(Computer::getRam).thenComparing(Computer::getSsd));
        print(computers);
        System.out.println("Total volume of ssd: " + totalSsd(computers));
        System.out.println("Average volume of ssd: " + avgSsd(computers));

    }

    private static void print(List<Computer> computers) {
        for (Computer computer : computers) {
            System.out.println(computer);
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    private static double totalSsd(List<Computer> computer){
        double res = 0;
        for (Computer c : computer){
            res += c.getSsd();
        }
        return res;
    }

    private static double avgSsd(List<Computer> computer){
        return totalSsd(computer) / computer.size();
    }

}
