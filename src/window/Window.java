package window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Window {

    public  static void findShortestArray(List<Integer> arrayList, int targetSum){
        int leftBorder = 0;
        int rightBorder = 0;
        int sum = 0;

        ArrayList<Integer> window = new ArrayList<>();
        int minValue = Integer.MAX_VALUE;
        int answerLeftBorder = 0;
        int answerRightBorder = 0;
        int size = 2;

        while (rightBorder < arrayList.size()){
            sum += arrayList.get(rightBorder);
            while (sum >= targetSum){
                int windowLength = rightBorder - leftBorder + 1;
                if(windowLength < minValue && sum == targetSum) {
                    answerLeftBorder = leftBorder;
                    answerRightBorder = rightBorder;
                    minValue = windowLength;
                }
                sum -= arrayList.get(leftBorder);
                leftBorder++;

            }
            rightBorder++;
        }
        if(minValue != Integer.MAX_VALUE){
            for (int i = answerLeftBorder; i < answerRightBorder; i++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> arrayList = List.of(2, 3, 1, 2, 4, 3);

        findShortestArray(arrayList, 7);
    }
}
