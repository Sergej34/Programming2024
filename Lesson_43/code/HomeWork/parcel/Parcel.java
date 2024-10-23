package HomeWork.parcel;

import java.util.Objects;

// Задача 2.(*)
//задача о Контейнерах и Посылках:
//Создайте класс Container с полями: String label (маркировка) и List - список коробок с посылками.
// Создайте класс Box с полем: List - список посылок. Классы Container и Box являются итерируемыми.
// Создайте класс Parcel (посылка) с полем double weight - вес посылки. Создайте класс ShipmentAppl с методом main.
// Задумайте случайное количество контейнеров (от 10 до 20). В каждом контейнере задумайте случайное количество коробок (от 10 до 20).
// В каждой коробке задумайте случайное количество посылок (от 5 до 10). Предположим, что каждая посылка в среднем имеет вес = 2 кг.
//Подсчитайте общее количество посылок во всех ящиках и их общий вес. Найдите label того из контейнеров,
// в котором оказалось максимальное количество посылок. Найдите все контейнеры с максимальным количеством посылок.
public class Parcel {
    private double weight;

    public Parcel(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Parcel parcel)) return false;
        return Double.compare(weight, parcel.weight) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(weight);
    }
}