// 회전하는 큐 - 실버 3
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class P1021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.offer(i);
        }

        st = new StringTokenizer(br.readLine());

        int result = 0;
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());

            // LinkedList는 indexOf 메소드를 직접 사용할 수 있어 더 효율적
            int targetIndex = deque.indexOf(target);

            // 왼쪽으로 이동이 빠른지, 오른쪽으로 이동이 빠른지 판단
            if (targetIndex <= deque.size() / 2) {
                // 왼쪽으로 이동 (2번 연산)
                for (int j = 0; j < targetIndex; j++) {
                    deque.addLast(deque.pollFirst());
                    result++;
                }
            } else {
                // 오른쪽으로 이동 (3번 연산)
                for (int j = 0; j < deque.size() - targetIndex; j++) {
                    deque.addFirst(deque.pollLast());
                    result++;
                }
            }

            // 첫 번째 원소 제거 (1번 연산)
            deque.pollFirst();
        }

        System.out.println(result);
    }
}