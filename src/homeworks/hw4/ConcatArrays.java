package homeworks.hw4;

import java.util.Arrays;

public class ConcatArrays {
    public static void main(String[] args) {

        int findElement = 7;

        int[] array1 =  {100, 112, 256, 349, 770};
        int[] array2 =  {72, 86, 113, 119, 265, 445, 892};
        int[] concatArr = concatSortArray(array1, array2);
        System.out.println(Arrays.toString(concatArr));
        System.out.println(concatArr[findElement - 1]);
        System.out.println(findElementWithoutConcat(array1, array2, findElement));

    }
    public static int[] concatSortArray(int[] arr1, int[] arr2){
        int[] concatArray = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] <= arr2[j]){
                concatArray[k] = arr1[i];
                i++;
            } else {
                concatArray[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < arr1.length){
            concatArray[k] = arr1[i];
            i++;
            k++;
        }
        while (j < arr2.length){
            concatArray[k] = arr2[j];
            j++;
            k++;
        }
        return concatArray;
    }

    public static int findElementWithoutConcat(int[] arr1, int[] arr2, int element){
        int i = 0, j = 0, count = 0;
        while (i < arr1.length && j < arr2.length){
            if (arr1[i] <= arr2[j]) {
                count++;
                if (element == count) {
                    return arr1[i];
                }
                i++;
            }
                else {
                    count++;
                if (element == count) {
                    return arr2[j];
                }
                j++;
                }
            }
        while (i < arr1.length){
            count++;
            if (count == element){
                return arr1[i];
            }
            i++;
        }
        while (j < arr2.length){
            count++;
            if (count == element){
                return arr2[j];
            }
            j++;
        }
        return -1;
    }
}
