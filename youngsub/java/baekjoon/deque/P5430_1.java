// AC - 골드 5
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;

public class P5430_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());

            String arrStr = br.readLine();
            String numStr = arrStr.substring(1, arrStr.length() - 1);
            Deque<Integer> deque = new ArrayDeque<>();
            if (!numStr.isEmpty()) {
                String[] nums = numStr.split(",");
                for (int j = 0; j < n; j++) {
                    deque.offer(Integer.parseInt(nums[j]));
                }
            }

            boolean isReverse = false;
            boolean isError = false;
            for (int j = 0; j < command.length(); j++) {
                if (command.charAt(j) == 'R') {
                    if (isReverse) {
                        isReverse = false;
                    } else {
                        isReverse = true;
                    }
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    if (!isReverse) {
                        deque.poll();
                    } else {
                        deque.pollLast();
                    }
                }
            }

            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");

                // 덱의 내용을 현재 방향에 맞게 출력
                if (!deque.isEmpty()) {
                    if (!isReverse) {
                        sb.append(deque.pollFirst());
                        while (!deque.isEmpty()) {
                            sb.append(",").append(deque.pollFirst());
                        }
                    } else {
                        sb.append(deque.pollLast());
                        while (!deque.isEmpty()) {
                            sb.append(",").append(deque.pollLast());
                        }
                    }
                }

                sb.append("]\n");
            }

        }

        System.out.println(sb);
    }
}