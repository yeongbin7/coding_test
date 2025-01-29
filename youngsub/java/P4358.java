// 문자열 - 생태학

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class P4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int count = 0;
        Map<String, Integer> map = new HashMap<>();

        while ((line = br.readLine()) != null) {  // 입력이 없을 때까지 반복
            count++;
            if (map.get(line) == null) {
                map.put(line, 1);
            } else {
                map.put(line, map.get(line) + 1);
            }
        }

        List<String> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet);

        for (String key : keySet) {
            System.out.print(key + " ");
            System.out.println(Math.round((map.get(key) / (double) count * 100) * 10000) / 10000.0);
        }


        br.close();
    }
}