import java.util.ArrayList;
import java.util.List;

public class CoinChanger {

    public static List<Integer> change(List<Integer> availableCoin, Integer money){
        availableCoin.sort(Integer::compareTo);
        List<Integer> result = new ArrayList<>();
        for (int i = availableCoin.size() - 1; i >= 0 ; i--) {
            int numOfCoin = money / availableCoin.get(i);
            money %= availableCoin.get(i);
            for (int j = 0; j < numOfCoin; j++) {
                result.add(availableCoin.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.println(change(new ArrayList<>(List.of(1, 2, 5, 10)), 68));
    }
}
