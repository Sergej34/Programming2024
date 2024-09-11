package Homework_33.myarray_iterator.model;

import java.util.Iterator;

public class  MyArrayIterator implements Iterator<Integer> {

    private Integer[] array;
    private int length;
    private int currPos;

    public MyArrayIterator(Integer[] array) {
        this.array = array;
        this.length = array.length;
    }

    @Override
    public boolean hasNext() {
        return currPos < length;
    }

    @Override
    public Integer next() {
        Integer current = array[currPos];
        currPos++;
        return current;
    }
    @Override
    public void remove() {
        // Сдвигаем все элементы от текущего индекса на одну позицию влево, затираем текущий элемент
        for (int i = currPos - 1; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = null;
        length--; // уменьшаем длину массива
        currPos--; // двигаем курсор влево
        // array = Arrays.copyOf(array, length); // копируем в новый массив с новой длиной

    }

}
