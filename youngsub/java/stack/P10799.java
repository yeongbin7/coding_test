// 쇠막대기 - 실버 2
import java.util.*;

public class P10799 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.next();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                stack.pop();
                if (line.charAt(i - 1) == '(') {
                    // 레이저
                    result += stack.size();
                } else {
                    // 막대 끝
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}