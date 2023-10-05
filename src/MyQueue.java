import java.util.Arrays;

public class MyQueue {
    private int top;
    private int size;
    private Integer[] array;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public MyQueue(int capacity){
        this.capacity = capacity;
        array = new Integer[capacity];
        size = 0;
    }

    public void push(Integer elm){
        if (size >= capacity){
            increaseCapacity();
        }
        array[top++] = elm;
        size++;
    }
    public Integer pop(){
        if(size > 0){
            return null;
        }
        Integer answer = array[0];

        for (int i = 1; i < top; i++){
            array[i - 1] = array[i];
        }
        array[--top] = null;
        size--;
        return answer;
    }

    public void increaseCapacity(){
        capacity *= 2;
        array = Arrays.copyOf(array, capacity);
    }
}
