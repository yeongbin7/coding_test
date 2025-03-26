// 괄호 - 실버 4
import java.util.*;

public class P9012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String line = sc.next();

            if (line.length() % 2 == 1) {
                sb.append("NO").append('\n');
                continue;
            }

            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);

                if (c == '(') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        isBalanced = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }

            if (stack.isEmpty() && isBalanced) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}