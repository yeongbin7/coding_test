// AC - 골드 5
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Deque;
import java.util.ArrayDeque;

public class P5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arrStr = br.readLine();

            // 대괄호 제거 및 쉼표로 분리
            String numStr = arrStr.substring(1, arrStr.length() - 1);

            Deque<Integer> deque = new ArrayDeque<>();

            // 빈 배열이 아닌 경우에만 파싱
            if (!numStr.isEmpty()) {
                String[] nums = numStr.split(",");
                for (int j = 0; j < n; j++) {
                    deque.add(Integer.parseInt(nums[j]));
                }
            }

            boolean isReversed = false;
            boolean isError = false;

            // 명령 수행
            for (int j = 0; j < command.length(); j++) {
                char cmd = command.charAt(j);

                if (cmd == 'R') {
                    isReversed = !isReversed; // 방향 전환 (실제 뒤집지 않고 상태만 변경)
                } else if (cmd == 'D') {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    }

                    // 현재 방향에 따라 앞이나 뒤에서 제거
                    if (isReversed) {
                        deque.removeLast();
                    } else {
                        deque.removeFirst();
                    }
                }
            }

            // 결과 출력
            if (isError) {
                sb.append("error\n");
            } else {
                sb.append("[");

                // 덱의 내용을 현재 방향에 맞게 출력
                if (!deque.isEmpty()) {
                    if (!isReversed) {
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

        System.out.print(sb);
    }
}