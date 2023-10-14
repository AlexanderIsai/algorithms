import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashTable {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(4);
        countElmRepeat(arrayList); // 1, 1, 2, 3, 4, 4

    }

    private static void countElmRepeat(ArrayList<Integer> arrayList){
        Map<Integer, Integer> repeatMap = new HashMap<>();

        for (Integer elm: arrayList) {
            if(repeatMap.containsKey(elm)) {
                repeatMap.put(elm, repeatMap.get(elm) + 1);
            }
            else {
                repeatMap.put(elm, 1);
            }
        }
        System.out.println(repeatMap);
//        for (Map.Entry<Integer, Integer> entry : repeatMap.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
//        }
    }
}
