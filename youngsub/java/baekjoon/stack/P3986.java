// 좋은 단어 - 실버 4
import java.util.*;

public class P3986 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int result = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            if (line.length() % 2 == 1) {
                continue;
            }

            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }

            if (stack.isEmpty()) result++;
        }

        System.out.println(result);
    }
}