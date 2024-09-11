package Homework_33.iterator_fibonacci.ait.fibonacci.model;


public class FibonacciAppl {
    public static void main(String[] args) {
        //берём   создаём
        //Класс   Объект      на базе конструктора вызываем new Fibonacci
        Fibonacci fibonacci = new Fibonacci(8);
        // TODO print all numbers, and calculate sum
        // 1, 1, 2, 3, 5, 8, 13, 21
        // sum = 54
                // называем
                // переменная
            //метод  fib     объект
        for (Integer fib : fibonacci){
            System.out.print(fib + " | ");
        }
        System.out.println();
        System.out.println("--------------------------------------");

        // - сложить все эти числа
        // sum = 54
        int sum = 0;
        for (Integer num : fibonacci){
            sum += num;
            // System.out.println(num);
        }
        System.out.println("Sum = " + sum);

    }
}
