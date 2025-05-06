import java.util.*;

public class BiggestNumber {
    public String solution(int[] numbers) {
        Integer[] boxedNumbers = Arrays.stream(numbers)
                .boxed()
                .toArray(Integer[]::new);

        Arrays.sort(boxedNumbers, (a, b) -> {
            String num1 = a + "" + b;
            String num2 = b + "" + a;
            return num2.compareTo(num1);
        });

        // 모든 수가 0인 경우 예외 처리
        if (boxedNumbers[0] == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : boxedNumbers) {
            sb.append(i);
        }

        return sb.toString();
    }
}