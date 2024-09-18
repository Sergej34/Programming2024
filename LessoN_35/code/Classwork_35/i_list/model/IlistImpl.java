package Classwork_35.i_list.model;

import java.util.Arrays;
import java.util.Iterator;

public class IlistImpl<E> implements Ilist<E> {
    // Object[] это дедушка всех объектов от него наследуется все объекты в java просто это нигде не пишется
    Object[] elements;
    private int size; // размер листа списка

    // constructor
    // создадим Ilist на ту capacity которая нам нужна
    public IlistImpl(int initialCapacity) {
        if (initialCapacity < 0) { // если нам прислали initialCapacity < 0
            throw new IllegalArgumentException("Illegal capacity = " + initialCapacity); // бросаемся нашим исключением
            // ищите пожалуйста такую ошибку -
            // IllegalArgumentException это тип ошибки что дали не верный аргумент
        }
        this.elements = new Object[initialCapacity];
    }

    // constructor
    public IlistImpl() {
        this(10); // 10 минимальный размер для листа / this это обращение к конструктору
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    // чистим наш список
    public void clean() {
        // стираем весь массив чтобы освободить память
        for (int i = 0; i < size; i++) {
            elements[i] = null; // чтобы уничтожить нужно прировнять null
        }
        // обнулили
        size = 0;
    }

    @Override
    // добавляем элемент в конец списка
    public boolean add(E element) {
        // напишу метод который будет проверять есть ли у меня куда добавлять
        ensureCapacity();
        elements[size++] = element; // на elements позицию [size++] добавляем наш элемент/добавили элемент size подвинули
        return true; // если добавится return true;
    }

    // плохие случаи
    private void ensureCapacity() { // проверка возможность вставки / ensure - быть уверенным
        if (size == elements.length) {
            if (size == Integer.MAX_VALUE) {
                throw new OutOfMemoryError(); // большего по размеру списка массива создать не можем

            }
            // как только длина массива заканчивается мы его в 1,5 раза увеличиваем
            int newCapacity = elements.length + elements.length / 2; // вырастили длину массива в 1,5 раза
            if (newCapacity < 0) { // если newCapacity стала отрицательной
                // проверяем перевали ли мы за MAX_VALUE если перевалили сбрасываем до MAX_VALUE
                newCapacity = Integer.MAX_VALUE; // приравнивается максимально возможного // если завалило за память компьютера мы достигли конца больше не могу увеличивать
            }
            // новый elements копируем в этот же массив только у него длина newCapacity
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    @Override
    public boolean add(int index, E element) {
        if (index == size) { // это значит добавляем в конец списка
            add(element);
            return true;
        }
        // добавляем в середину списка
        checkIndex(index);
        ensureCapacity(); // проверка возможности вставки
        System.arraycopy(elements, index, elements, index + 1, size++ - index); // раздвинули массив на 1 позицию
        elements[index] = element;
        return true;
    }

    private void checkIndex(int index) {
        // индекс не может быть отрицательным или больше чем size
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Wrong index: " + index);
        }
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        // ищем элемент списка
        E el = (E) elements[index];
        // удаляем элемент
        System.arraycopy(elements, index + 1, elements, index, --size - index);
        elements[size] = null;
        return el;
    }
    //    После выполнения System.arraycopy, когда элементы сдвигаются на одну позицию назад,
//    последний элемент становится дублированным на предпоследней позиции.
//    Затирание последнего элемента elements[size] = null; выполняется для очистки этой дублированной позиции,
//    иначе в списке может остаться ссылка на ненужный объект, что может вызвать утечку памяти.
//    Этот шаг необходим для правильной работы списка и предотвращения утечек памяти. В Java объекты не удаляются
//    сразу после вызова remove, и сборка мусора может произойти позже. Поэтому затирание последнего элемента является
//    хорошей практикой для избежания утечек памяти.

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E victim = (E) elements[index];
        elements[index] = element;
        return victim;
    }

    @Override
    public int indexOf(Object o) {
        if (o != null) { // если о не null
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(o)) {
                    return i;
                }

            }

        } else {
            for (int i = 0; i < size; i++) {
                if (null == elements[i]) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        // TODO
        return 0;
    }

    @Override
    // публичный метод который должен вернуть тип Iterator который перебирает элементы
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int i = 0; // заведём i и начинается список с нуля(индекс)

            @Override
            public boolean hasNext() {
                // можем двигаться пока i меньше size
                return i < size; // можем двигаться внутри этого списка которое принимает true пока
                // можем двигаться внутри списка когда дойдём до конца должно сказать false
            }

            @Override
            public E next() {
                // вернём элемент E тип того массива и двигаемся увеличиваем i++
                return (E) elements[i++];
            }
        };
    }
}
