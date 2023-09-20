package homeworks;

public class TimSort {
    static int RUN = 32;

    public static void insertionSort(int[] arr, int left, int right) { //объявляем функцию, куда передаем массив и левый и правый индексы
        for (int i = left + 1; i <= right; i++) { // запускаем цикл от второго элемента этого массива
            int j = i; // заводим новую переменную, куда заносим значение счетчика
            int key = arr[j]; //заводим новую переменную, куда заносим значение элемента массива по новому индексу
            while (j > left && arr[j - 1] > key) { // запускаем цикл, пока новый индекс больше левой границы массива, а предыдущий элемент больше текущего
                arr[j] = arr[j - 1];//в текущий элемент (по новому счетчику записываем предыдущий
                j--; //уменьшаем счетчик
            }
            arr[j] = key; // в текущий элемент массива (по новому счетчику) записываем сохраненное до цикла значение
        }
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int len1 = m - l + 1, len2 = r - m;
        int[] left = new int[len1];
        int[] right = new int[len2];
        System.arraycopy(arr, l, left, 0, len1);
        System.arraycopy(arr, m + 1, right, 0, len2);
        int i = 0, j = 0;
        for (int k = l; k <= r; k++) {
            if (i < len1 && (j >= len2 || left[i] <= right[j])) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
        }
    }

    public static void timSort(int[] arr) { // объявляем метод тимСорт, передаем туда массив
        int n = arr.length; //объявляем и инициализируем переменную, в которую заносим длину массива
        for (int i = 0; i < n; i += RUN) { //запускаем цикл от 0-го элемента, пока счетчик меньше длины массива, увеличиваем счетчик на РАН (зачем-то))
            insertionSort(arr, i, Math.min(i + RUN - 1, n - 1)); // на каждой итерации вызываем функцию ИнсершнСорт, куда передаем массив, позицию счетчика и меньшее из значений
        }
        for (int size = RUN; size < n; size = 2 * size) {//запускаем цикл от РАН до конца массива, итерация в двойне
            for (int left = 0; left < n; left += 2 * size) { //внутри запускаем цикл по всему массиву, итерация - текущее значение + внешний счетчик вдвойне
                int mid = left + size - 1;// заводим новую переменную
                int right = Math.min((left + 2 * size - 1), (n - 1));
                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 21, 7, 23, 19}; // дан массив чисел
        timSort(arr); // вызываем функцию тимСорт и передаем туда наш массив
        for (int i : arr) { // запускаем цикл ФорИч для каждого элемента нашего массива
            System.out.print(i + " "); // выводим каждый элемент на экран с разделителем
        }
    }
}
