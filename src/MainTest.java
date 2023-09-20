import java.util.Arrays;

public class MainTest {

//Имея два отсортированных массива размера m и n соответственно, вам нужно найти элемент,
// который будет находиться на k-й позиции в конечном отсортированном массиве.
//Массив 1 - 100 112 256 349 770
//Массив 2 - 72 86 113 119 265 445 892
//к = 7
//Вывод : 256
//Окончательный отсортированный массив -
//72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
//7-й элемент этого массива равен 256.

    public static void main(String[] args) {
        int[] m = {5, 6, 7, 8, 9, 10, 11, 12};
        int[] n = {2, 3};
        int k = 4;
        System.out.println(getElement(m, n, k));
    }

    static int getElement(int[] a, int[] b, int e) {
        int aIndex = 0;
        int bIndex = 0;
        int result = 0;
        int i = 0;
        while (i < e) {
            if ((a[aIndex] < b[bIndex]) || (aIndex < a.length - 1)) {
                result = a[aIndex];
                aIndex++;
            } else {
                result = b[bIndex];
                if (bIndex < b.length - 1) {
                    bIndex++;
                }
            }
            i++;
        }
        return result;
    }
}