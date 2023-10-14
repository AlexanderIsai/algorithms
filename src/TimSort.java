public class TimSort { // Объявляем класс TimSort.

    static int RUN = 3; // Объявляем статическое целочисленное поле RUN и инициализируем его значением 32. Это определяет размер "малых" блоков для сортировки.

    public static void insertionSort(int[] arr, int left, int right) { // Объявляем метод insertionSort для сортировки вставкой.
        for (int i = left + 1; i <= right; i++) { // Начинаем цикл, проходящий по подмассиву arr[left:right].
            int j = i; // Инициализируем переменную j значением i.
            int key = arr[j]; // Запоминаем текущий элемент массива arr[j].
            while (j > left && arr[j - 1] > key) { // Начинаем цикл, сравнивая элементы и сдвигая их при необходимости.
                arr[j] = arr[j - 1]; // Сдвигаем элементы вправо.
                j = j - 1;
            }
            arr[j] = key; // Вставляем элемент key на правильное место в отсортированной части массива.
        }
    }

    public static void merge(int[] arr, int l, int m, int r) { // Объявляем метод merge для слияния двух отсортированных подмассивов.
        int len1 = m - l + 1, len2 = r - m; // Вычисляем длины подмассивов.
        int[] left = new int[len1]; // Создаем временный массив left для левой части.
        int[] right = new int[len2]; // Создаем временный массив right для правой части.
        System.arraycopy(arr, l, left, 0, len1); // Копируем левую часть во временный массив left.
        System.arraycopy(arr, m + 1, right, 0, len2); // Копируем правую часть во временный массив right.
        int i = 0, j = 0; // Инициализируем индексы для обхода left и right.
        for (int k = l; k <= r; k++) { // Начинаем цикл, который сливает left и right обратно в arr.
            if (i < len1 && (j >= len2 || left[i] <= right[j])) { // Сравниваем элементы left и right.
                arr[k] = left[i]; // Присваиваем arr значение из left.
                i++;
            } else {
                arr[k] = right[j]; // Присваиваем arr значение из right.
                j++;
            }
        }
    }

    public static void timSort(int[] arr) { // Объявляем метод timSort для сортировки TimSort.
        int n = arr.length; // Получаем длину массива.
        for (int i = 0; i < n; i += RUN) { // Начинаем цикл для сортировки малых блоков с использованием сортировки вставкой.
            insertionSort(arr, i, Math.min(i + RUN - 1, n - 1)); // Вызываем метод insertionSort для сортировки текущего блока.
        }
        for (int size = RUN; size < n; size = 2 * size) { // Начинаем цикл для слияния и сортировки блоков по алгоритму TimSort.
            for (int left = 0; left < n; left += 2 * size) { // Перебираем блоки размера size.
                int mid = left + size - 1; // Вычисляем середину текущего блока.
                int right = Math.min((left + 2 * size - 1), (n - 1)); // Вычисляем правую границу текущего блока.
                if (mid < right) { // Если есть место для слияния, то выполняем слияние.
                    merge(arr, left, mid, right); // Вызываем метод merge для слияния блоков.
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        TimSort.timSort(arr);
    }
}