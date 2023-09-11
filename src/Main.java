public class Main {
    public static int findMax(int[] array, int left, int right) {
        if (left == right) {
            return array[left]; // Базовый случай: массив из одного элемента
        }

        int mid = (left + right) / 2; // Находим середину массива

        // Рекурсивно находим максимумы в левой и правой половинах
        int leftMax = findMax(array, left, mid);
        int rightMax = findMax(array, mid + 1, right);

        // Возвращаем максимум из левой и правой половин
        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] array = {24, 7, 1, 8, 12, 5, 14, 19};

        int max = findMax(array, 0, array.length - 1);

        int max2 = searchMax(array);

        System.out.println("Максимальный элемент в массиве: " + max);
        System.out.println("Максимальный элемент в массиве: " + max2);
    }

    static int searchMax(int[] array){
        int leftBorder = 0;
        int rightBorder = array.length - 1;

        while (leftBorder <= rightBorder){
            int middleIndex = (leftBorder + rightBorder) / 2;

            if((middleIndex == 0 || array[middleIndex] >= array[middleIndex - 1]) && (middleIndex == array.length - 1 || array[middleIndex] >= array[middleIndex + 1])){
                return array[middleIndex];
            }
            if (array[middleIndex] > array[middleIndex+ 1]) {
                rightBorder= middleIndex - 1;
            } else {
                leftBorder = middleIndex + 1;
            }

        }
        return -1;
    }
}