// 스택 - 실버4
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class P10828 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            if (line.startsWith("push")) {
                stack.push(Integer.parseInt(line.split(" ")[1]));
            } else if (line.equals("pop")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append('\n');
                    continue;
                }

                sb.append(stack.pop()).append('\n');
            } else if (line.equals("size")) {
                sb.append(stack.size()).append('\n');
            } else if (line.equals("empty")) {
                if (stack.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (line.equals("top")) {
                if (stack.isEmpty()) {
                    sb.append(-1).append('\n');
                    continue;
                }

                sb.append(stack.peek()).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}