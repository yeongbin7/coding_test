// 숨바꼭질
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class P1697 {

    static class Point {
        int x, times;

        public Point(int x, int times) {
            this.x = x;
            this.times = times;
        }
    }

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        }

        visited = new boolean[100001];

        Queue<Point> queue = new LinkedList<>();
        visited[N] = true;
        queue.offer(new Point(N, 0));

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 3; i++) {
                int nx = 0;
                if (i == 0) {
                    nx = current.x - 1;
                } else if (i == 1) {
                    nx = current.x + 1;
                } else {
                    nx = 2 * current.x;
                }

                if (nx < 0 || nx >= 100001) {
                    continue;
                }

                if (!visited[nx]) {
                    if (nx == K) {
                        System.out.println(current.times + 1);
                        return;
                    }

                    visited[nx] = true;
                    queue.offer(new Point(nx, current.times + 1));
                }
            }
        }
    }
}