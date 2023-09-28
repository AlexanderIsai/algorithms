import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class StackOperation {
    private int top;
    private Integer[] array;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public StackOperation() {
        int top = 0;
        array = new Integer[DEFAULT_CAPACITY];
        size = 0;
        capacity = DEFAULT_CAPACITY;
    }

    public void push(Integer value){
        if(size == capacity){

        }
        array[top++] = value;
        size++;
    }
    private void increaseCapacity() {
        capacity *= 2;
        array = Arrays.copyOf(array, capacity);
    }

    private Integer pop(){
        if(size == 0){
            return null;
        }
        Integer answer = array[--top];
        array[top] = null;
        size--;
        return answer;
    }


    public static void main(String[] args) {



        LinkedList<Integer> linkedList = new LinkedList<>();
    }
}
