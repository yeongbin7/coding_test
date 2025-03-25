// 덱 - 실버 4
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;

public class P10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String command = br.readLine();
            if (command.startsWith("push_front")) {
                deque.addFirst(Integer.parseInt(command.split(" ")[1]));
            } else if (command.startsWith("push_back")) {
                deque.addLast(Integer.parseInt(command.split(" ")[1]));
            } else if (command.equals("pop_front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.poll()).append('\n');
                }
            } else if (command.equals("pop_back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.pollLast()).append('\n');
                }
            } else if (command.equals("size")) {
                sb.append(deque.size()).append('\n');
            } else if (command.equals("empty")) {
                if (deque.isEmpty()) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            } else if (command.equals("front")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.getFirst()).append('\n');
                }
            } else if (command.equals("back")) {
                if (deque.isEmpty()) {
                    sb.append(-1).append('\n');
                } else {
                    sb.append(deque.getLast()).append('\n');
                }
            }
        }

        System.out.println(sb.toString());
    }
}