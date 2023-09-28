import java.util.Arrays;

public class MainTest {


    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        System.out.println(dynamicArray);
        dynamicArray.add(1);
        System.out.println(dynamicArray);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
        dynamicArray.add(5);
        System.out.println(dynamicArray);
        dynamicArray.remove();
        System.out.println(dynamicArray);
        dynamicArray.remove();
//        System.out.println(dynamicArray);
        dynamicArray.add(4);
        dynamicArray.add(5);
        System.out.println(dynamicArray);
        dynamicArray.removeAt(3);
        System.out.println(dynamicArray);
        dynamicArray.add(4);
        System.out.println(dynamicArray);
        dynamicArray.setValue(3, 6);
        System.out.println(dynamicArray);
        dynamicArray.clean();
        System.out.println(dynamicArray);
        System.out.println(dynamicArray.isEmpty());
        System.out.println(dynamicArray);
        dynamicArray.add(1);
        System.out.println(dynamicArray.isEmpty());
        System.out.println(dynamicArray);
        dynamicArray.add(2);
        System.out.println(dynamicArray);
        dynamicArray.add(3);
        System.out.println(dynamicArray);
        dynamicArray.add(4);
        dynamicArray.add(5);
        System.out.println(dynamicArray);
        System.out.println(dynamicArray.contains(5));
        System.out.println(dynamicArray.isEmpty());
    }
}