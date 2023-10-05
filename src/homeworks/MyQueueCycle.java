package homeworks;

public class MyQueueCycle {

    private int head;
    private int top;
    private int size;
    private Integer[] array;
    private int capacity;

    public MyQueueCycle(int capacity){
        this.capacity = capacity;
        array = new Integer[capacity];
        head = 0;
        top = 0;
        size = 0;
    }
    public void push(Integer elm){
        if((top + 1) % capacity == head){
            throw  new RuntimeException("Queue is full");
        }
        array[top] = elm;
        top = (top + 1) % capacity;
        size++;
    }

    public Integer pop(){
        if (size == 0){
            return null;
        }
        Integer answer = array[head];
        array[head] = null;
        head = (head + 1) % capacity;
        size--;
        return answer;
    }

}
