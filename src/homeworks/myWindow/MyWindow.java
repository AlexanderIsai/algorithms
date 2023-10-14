package homeworks.myWindow;

public class MyWindow {
    static int size = 1;

    public static void main(String[] args) {
        int[] array = {1, 3, 2, 4, 3, 5, 4, 6, 5, 3, 4, 2, 1};
        myWindowMethod(array, 22);
    }

    public static void myWindowMethod(int[] array, int target) {
        while (size >= 1 && size <= array.length) {
            moveWindow(array, target);
        }
    }

    public static int sumOfArray(int[] array, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }

    public static void moveWindow(int[] array, int target) {
        size++;
        if (size == array.length) {
            System.out.println("This is impossible");
        }
        int start = 0;
        int end = start + size;
        int temp;
        for (int i = 0; i < array.length - size; i++) {
            temp = sumOfArray(array, start, end);
            if (temp == target) {
                System.out.println(" window size is - " + size + ". Index from " + start + " to " + end);
                size = -1;
                return;
            } else {
                start++;
                end++;
            }
        }
    }
}
