// 벽 부수고 이동하기

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class P2206 {

    static class Point {
        int x, y;
        int distance;
        int broken;

        public Point(int x, int y, int distance, int broken) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.broken = broken;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int result = -1;

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == N - 1 && current.y == M - 1) {
                result = current.distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if (map[nx][ny] == 0) {
                    if (!visited[nx][ny][current.broken]) {
                        queue.offer(new Point(nx, ny, current.distance + 1, current.broken));
                        visited[nx][ny][current.broken] = true;
                    }
                } else {
                    if (current.broken == 0 && !visited[nx][ny][1]) {
                        queue.offer(new Point(nx, ny, current.distance + 1, 1));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        System.out.println(result);
    }
}