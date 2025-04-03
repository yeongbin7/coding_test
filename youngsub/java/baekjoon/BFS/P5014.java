// 스타트링크 - 실버 1
import java.io.*;
import java.util.*;

public class P5014 {

    static class Point {
        int x, times;

        public Point(int x, int times) {
            this.x = x;
            this.times = times;
        }
    }

    public static void main(String[] args) throws IOException {
        // F: 건물 층수
        // S: 현위치
        // G: 스타트링크의 층수
        // U: 위로 U층을 가는 버튼
        // D: 아래로 D층을 가는 버튼
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[F + 1];

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(S, 0));
        visited[S] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == G) {
                System.out.println(current.times);
                return;
            }

            for (int i = 0; i < 2; i++) {
                int nx;
                if (i == 0) {
                    nx = current.x + U;
                } else {
                    nx = current.x - D;
                }

                if (nx < 1 || nx >= F + 1) {
                    continue;
                }

                if (!visited[nx]) {
                    queue.offer(new Point(nx, current.times + 1));
                    visited[nx] = true;
                }
            }
        }

        System.out.println("use the stairs");
    }
}