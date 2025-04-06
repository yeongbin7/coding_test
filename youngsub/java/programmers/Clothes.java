// 의상 - 레벨 2
import java.util.*;

public class Clothes {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 1) + 1);
        }

        int result = 1;
        for (String key : map.keySet()) {
            result *= map.get(key);
        }

        return result - 1;
    }
}