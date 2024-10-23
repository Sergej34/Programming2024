package HomeWork.parcel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Задача 2.(*)
//задача о Контейнерах и Посылках:
//Создайте класс Container с полями: String label (маркировка) и List - список коробок с посылками.
// Создайте класс Box с полем: List - список посылок. Классы Container и Box являются итерируемыми.
// Создайте класс Parcel (посылка) с полем double weight - вес посылки. Создайте класс ShipmentAppl с методом main.
// Задумайте случайное количество контейнеров (от 10 до 20). В каждом контейнере задумайте случайное количество коробок (от 10 до 20).
// В каждой коробке задумайте случайное количество посылок (от 5 до 10). Предположим, что каждая посылка в среднем имеет вес = 2 кг.
//Подсчитайте общее количество посылок во всех ящиках и их общий вес. Найдите label того из контейнеров,
// в котором оказалось максимальное количество посылок. Найдите все контейнеры с максимальным количеством посылок.

public class Container implements Iterable<Box>{
    private String label;
    List<Box> boxes;

    public Container(String label) {
        this.label = label;
        boxes = new ArrayList<>();
    }

    public String getLabel() {
        return label;
    }

    public List<Box> getBoxes() {
        return boxes;
    }

    public boolean addBox(Box box){
        return boxes.add(box);
    }

    public double weight() {
        return boxes.stream()
                .mapToDouble(b -> b.weightBox())
                .sum();
    }
    public int quantity(){
        return boxes.size();
    }
    public int countParcels(){
        return boxes.stream()
                .mapToInt(p -> p.quantity())
                .sum();
    }

    @Override
    public String toString() {
        return "Container label " + label +
                ", parsels " + countParcels();
    }

    @Override
    public Iterator<Box> iterator() {
        return boxes.iterator();
    }

}
