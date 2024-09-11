package HomeWork34;

import java.util.Arrays;
import java.util.Random;


public class RandomArrays {
    public static void main(String[] args) {

        int[] arr = new int[100];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1000);
        }
        System.out.println("Исходный массив: " + Arrays.toString(arr));

        int count = 0;
        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    // переставим элементы местами
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    count++;
                }
            }
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
        System.out.println("Количество обменов: " + count);
    }
}
