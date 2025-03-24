// 스택 수열 - 실버2
import java.util.Scanner;
import java.util.Stack;

public class P1874 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] used = new boolean[n + 1];

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int current = 1;
        for (int i = 0; i < n; i++) {
            int target = sc.nextInt();

            while (current <= target) {
                stack.push(current++);
                sb.append('+').append('\n');
            }

            if (!stack.isEmpty() && target == stack.peek()) {
                stack.pop();
                sb.append('-').append('\n');
            } else {
                System.out.println("NO");
                return;
            }
        }

        System.out.println(sb.toString());
    }
}