package Classwork_35.i_list.model;
// зададим абстрактные методы для работы со структурой данных "лист/list" (список чего-то),
// для любых типов данных Integer, String, StringBuilder, Employee, Car, Pet, Photo, Book ...

import java.util.ArrayList;
import java.util.List;

public interface Ilist<E> extends Iterable<E> {

    int size(); // выяснить какой размер списка

    default boolean isEmpty() { // если лист пустой, то true
        return size() == 0;
    }

    void clean(); // чистим список если мы его закончили выполнять

    boolean add(E element); // добавляет элемент

    // логический метод можно реализовать сразу
    // есть ли элемент(объект) в списке / contains - содержится
    default boolean contains(Object o) {
        // будем возвращать indexOf некоторого объекта который пришёл на вход
        return indexOf(o) >= 0; // да элемент есть в нашем листе true если он больше или равен нулю
    }
    // удаляет объект из списка
    default boolean remove(Object o) {
        int index = indexOf(o); // индекс позиции / отдали объект (o) получили index
        if(index < 0){ // когда объекта нет в нашем списке(если индекс отрицательный)
            return false;
        }
        // remove по этому index
        remove(index);
        return true;
    }
    // добавлять на определённую позицию элемент по индексу который наполняется наш список
    boolean add(int index, E element);

    // возвратим элемент при удалении (показываем)
    E remove(int index);

    // найдём и возьмём элемент который стоит на индексе нужно вернуть сам элемент
    E get(int index);

    // на определённое место поставить элемент по индексу вернём сам элемент
    E set(int index, E element);
    // идёт слева на право
    // мы хоти знать какой индекс у какогото объекта в нашем списке
    int indexOf(Object o);

    // несколько одинаковых элементов может быть
    // найти первый попавшийся с конца элемент идёт с права на лево
    int lastIndexOf(Object o);

    List<Double> listOfWeight = new ArrayList<>();
}
