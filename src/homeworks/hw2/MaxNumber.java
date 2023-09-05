package homeworks.hw2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MaxNumber {

    public static void main(String[] args) {

        int[] array = createRandomIntegerArray();

        System.out.println("findMaxElement - " + findMaxElement(array));
        System.out.println("getMaxElement - " + getMaxElement(array));

    }

//    Так как массив не отсортирован, мы можем использовать 2 пути:
//    1. Описанный ниже метод findMaxElement, сложность которого будет линейной, т.е. О(n).
//    Т.е. мы проходимся по массиву и сравниваем каждый его элемент с максимумом.
//    2. Для примера приведен способ, описанный в методе getMaxElement.
//    Это очевидно менее эффективный способ, потому что сначала мы сортируем массив по возрастанию, а потом
//    выводим его последний элемент.
//    Согласно ряду источников, метод sort у массивов часто работает за сложность от О(n*log2n) до О(n^2), что
//    всегда больше, чем О(n). Проверка временем выполнения это подтверждает.

    public static int findMaxElement(int[] array) {
        int max = array[0];
        long startTime = System.nanoTime();
        for (int i = 1; i < array.length; i++) {
            max = Math.max(array[i], max);
        }
        long endTime = System.nanoTime();
        System.out.println("Time of Find-method is = " + (endTime - startTime));
        return max;
    }

    public static int getMaxElement(int[] array) {
        long startTime = System.nanoTime();
        Arrays.sort(array);
        long endTime = System.nanoTime();
        System.out.println("Time of Get-method is = " + (endTime - startTime));
        return array[array.length - 1];
    }


    public static int[] createRandomIntegerArray() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива");
        int arraySize = scanner.nextInt();
        System.out.println("Введите минимальное число массива");
        int minValue = scanner.nextInt();
        System.out.println("Введите максимальное число массива");
        int maxValue = scanner.nextInt();
        int[] array = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            array[i] = random.nextInt(minValue, maxValue + 1);
        }
        System.out.println(Arrays.toString(array));
        return array;
    }
}
