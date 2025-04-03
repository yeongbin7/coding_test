// 숨바꼭질 - 실버 1
import java.io.*;
import java.util.*;

public class P1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            return;
        }

        int[] map = new int[100001];
        // map 수빈이가 해당 인덱스에 있을 수 있는 시간을 저장하기 위해서 초기 값을 1로 설정해주고 마지막에 1을 빼주는 형식으로 생각
        map[N] = 1;
        boolean[] visited = new boolean[100001];

        Queue<Integer> queue = new LinkedList<>();
        visited[N] = true;
        queue.offer(N);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (int i = 0; i < 3; i++) {

                // 초기화용
                int nx = -1;
                if (i == 0) {
                    nx = current - 1;
                } else if (i == 1) {
                    nx = current + 1;
                } else {
                    nx = current * 2;
                }

                if (nx == K) {
                    System.out.println(map[current]);
                    return;
                }

                if (nx < 0 || nx >= 100001) {
                    continue;
                }

                if (!visited[nx] && map[nx] == 0) {
                    map[nx] = map[current] + 1;
                    visited[nx] = true;
                    queue.offer(nx);
                }
            }
        }
    }
}