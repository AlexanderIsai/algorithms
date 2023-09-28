import java.util.Arrays;

public class DynamicArray {

    private Integer[] array;
    private int length;
    private int capacity;

    public DynamicArray() {
        this.array = new Integer[1];
        this.length = 0;
        this.capacity = 1;
    }

    public void add(Integer element) {

        if (this.length == this.capacity) {
//            this.capacity *= 2;
//            this.array = Arrays.copyOf(this.array, this.capacity);
            growSize();
        }
        this.array[length++] = element;
    }

    // 0. arr = [], length = 0, capacity = 1
    // 1. arr[1], length = 1, capacity = 1 O(1)
    // 2. arr[1, 2], length = 2, capacity = 2 O(1) + 0(1)
    // 3. arr[1, 2, 3, ...], length = 3, capacity = 4 O(2) + 0(1)
    //....
    // 4. arr[1, 2, 3, ..., n], length = n, capacity = n O(n) + 0(1)
    // 0(1) * n + ((O(1) + O(2) + O(4) + ... + O(n)) = O(n)
    // O(n) / n = O(1)
    //=======================================================

    /*
    добавить элемент 1, увеличить капасити - текущий размер массива. Каждый элемент приносит 3
   0. arr = [], length = 0, capacity = 1 money = 0
   1. arr[1], length = 1, capacity = 1  money = 2 , +3 -1
   2. arr[1, 2], length = 2, capacity = 2 money = 3, + 3 -2
   3. arr[1, 2, 3], length = 3, capacity = 4 money = 3, +3 -3
   4. arr[1, 2, 3, 4], length = 4, capacity = 4 money = 5, +3 -1
   5. arr[1, 2, 3, 4, 5], length = 5, capacity = 8 money = 3, +3 -5
   6. arr[1, 2, 3, 4, 5, 6], length = 6, capacity = 8 money = 5, +3 -1
   7. arr[1, 2, 3, 4, 5, 6, 7] length = 7, capacity = 8 money = 7, +3 -1
   8. arr[1, 2, 3, 4, 5, 6, 7, 8] length = 8, capacity = 8 money = 9, +3 -1
   9. arr[1, 2, 3, 4, 5, 6, 7, 8, 9] length = 9, capacity = 16 money = 3, +3 -9


     */


    public Integer get(int index) {
        if (index < 0 || index >= length) {
            throw new ArrayIndexOutOfBoundsException("Index is out of bounds");
        }
        return array[index];
    }

    public void print() {
        for (Integer i : this.array) {
            System.out.println(i);
        }
    }

    //    remove() - удаляет последний
    public void remove() {
        this.setLength(this.getLength() - 1);
        Integer[] newArr = new Integer[this.capacity];
        for (int i = 1; i < newArr.length; i++) {
            if (this.array[i] != null) {
                newArr[i - 1] = this.array[i - 1];
            } else newArr[i] = null;
            newArr[newArr.length - 1] = null;
        }
        this.array = newArr;
        reduce();
    }

    private void reduce() {
        if (this.capacity >= this.getLength() * 2) {
            this.capacity = this.capacity / 2;
            Integer[] newArray = new Integer[this.capacity];
            System.arraycopy(array, 0, newArray, 0, newArray.length);
            this.array = newArray;
        }
    }

    //    removeAt(index) - удаляет по индексу
    public void removeAt(int index) {
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = null;
        this.setLength(this.getLength() - 1);
        reduce();
    }

    //    growSize() - увеличивает размер
    private void growSize() {
        this.capacity *= 2;
        this.array = Arrays.copyOf(this.array, this.capacity);
    }

    //    set(index, data) - изменяет элемент
    public void setValue(int index, Integer element) {
        this.array[index] = element;
    }

    public void clean() {
        this.capacity = 1;
        setLength(0);
        this.array = Arrays.copyOf(this.array, this.capacity);
    }

    //    contains(data) - проверяет существует ли элемент
    public boolean contains(Integer data) {
        boolean isContains = false;
        for (Integer element : this.array) {
            if (element == data) {
                isContains = true;
            }
        }
        return isContains;
    }

//    isEmpty() - вернет false, если в структуре есть элемент

    public boolean isEmpty(){
        return (this.getLength() == 0) ? true : false;
    }




    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer[] array) {
        this.array = array;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "DynamicArray{" +
                "array=" + Arrays.toString(array) +
                ", length=" + length +
                ", capacity=" + capacity +
                '}';
    }
}
