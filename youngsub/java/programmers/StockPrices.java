import java.util.*;

public class StockPrices {

    public static int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            result[index] = prices.length - 1 - index;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3})));
    }
}