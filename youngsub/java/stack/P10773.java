// 제로 - 실버4
import java.util.Scanner;
import java.util.Stack;

public class P10773 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < K; i++) {
            int number = sc.nextInt();
            if (number == 0) {
                stack.pop();
            } else {
                stack.push(number);
            }
        }

        int answer = 0;
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        System.out.println(answer);
    }
}