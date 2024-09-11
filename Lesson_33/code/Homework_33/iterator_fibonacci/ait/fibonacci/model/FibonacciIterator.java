package Homework_33.iterator_fibonacci.ait.fibonacci.model;
//Задача 2(*) Завершить аппликацию Fibonacci. Все уточнения в комментариях к коду.

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {

    // fields
    private int quantity;
    private int prevNum;
    private int prevPrevNum;
    private int counter;

    // constructor

    public FibonacciIterator(int quantity) {
        this.quantity = quantity;
        this.prevNum = 1;
        this.prevPrevNum = 1;
        this.counter = 1;
    }

    @Override
    public boolean hasNext() {
        return counter <= quantity; // - проверка на кол-во чисел в ряду
    }


    @Override
    public Integer next() {
        if (counter++ <= 2) {
            return 1;
        }
        int currNum = prevNum; // текущее число
        prevNum = prevPrevNum + prevNum; // вычисляем следующее как сумму двух предыдущих
        prevPrevNum = currNum; // переносим текущее число
        return prevNum; // - как получить сл. число Фибоначчи в ряду = предыдущее + текущее
    }
}
