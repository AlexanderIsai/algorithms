package homeworks.hw1;

import java.util.Scanner;

public class Homework1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите три числа через пробел");
        String stringNumbers = scanner.nextLine();
        String[] arrayNumbers = stringNumbers.split(" ");
        int[] numbers = convertStringToNumbers(arrayNumbers);
        System.out.println("Сумма элементов массива = " + sumNumbersOfArray(numbers));
    }
    private static int[] convertStringToNumbers(String[] arrayString) {
        int[] newArrayNumbers = new int[arrayString.length];
        for (int i = 0; i < newArrayNumbers.length; i++) {
            newArrayNumbers[i] = Integer.parseInt(arrayString[i]);
        }
        return newArrayNumbers;
    }

    private static int sumNumbersOfArray(int[] array){
        int result = 0;
        for (int element : array) {
            result += element;
        }
        return result;
    }
}
