package HomeWork.parcel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Задача 2.(*)
//задача о Контейнерах и Посылках:
//Создайте класс Container с полями: String label (маркировка) и List - список коробок с посылками.
// Создайте класс Box с полем: List - список посылок. Классы Container и Box являются итерируемыми.
// Создайте класс Parcel (посылка) с полем double weight - вес посылки. Создайте класс ShipmentAppl
// с методом main. Задумайте случайное количество контейнеров (от 10 до 20). В каждом контейнере задумайте
//случайное количество коробок (от 10 до 20). В каждой коробке задумайте случайное количество посылок
//(от 5 до 10). Предположим, что каждая посылка в среднем имеет вес = 2 кг.
//Подсчитайте общее количество посылок во всех ящиках и их общий вес. Найдите label того из контейнеров,
// в котором оказалось максимальное количество посылок. Найдите все контейнеры с максимальным количеством
// посылок.
public class Box implements Iterable<Parcel>{
    private List<Parcel> parcels;

   public Box(List<Parcel> parcels) {
        // Динамическое изменение размера в контексте коллекций, таких как ArrayList в Java, означает,
        // что размер списка автоматически увеличивается или уменьшается по мере добавления или удаления
        // элементов, без необходимости явно указывать фиксированный размер на момент создания.
        this.parcels = new ArrayList<>();
    }
    // конструктор по умолчанию / Гибкость при создании объектов / Удобство для инициализации пустого состояния / Полиморфизм и наследование
    public Box() {
        parcels = new ArrayList<>();
    }

    public List<Parcel> getParcels() {
        return parcels;
    }

    public boolean addParcel(Parcel parcel) {
       return parcels.add(new Parcel(2)); //добавляем посылку в бокс с весом 2 кг
    }

    public int quantity(){
        return parcels.size();
    }
    // вес коробки = сумме весов всех посылок
    public double weightBox(){
        return parcels.stream()
                .mapToDouble(Parcel::getWeight)
                .sum();
    }

    @Override
    public Iterator<Parcel> iterator() {
        return parcels.iterator();
    }

}
