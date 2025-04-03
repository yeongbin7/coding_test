// 나이트의 이동 - 실버 1
import java.io.*;
import java.util.*;

public class P7562 {

    static class Point {
        int x, y, times;

        public Point(int x, int y, int times) {
            this.x = x;
            this.y = y;
            this.times = times;
        }
    }

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            boolean[][] visited = new boolean[N][N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            Point startPoint = new Point(startX, startY, 0);

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            if (startX == targetX && startY == targetY) {
                sb.append(0).append('\n');
                continue;
            }

            Queue<Point> queue = new LinkedList<>();
            queue.offer(startPoint);
            visited[startX][startY] = true;

            boolean isFind = false;
            while (!queue.isEmpty()) {
                Point current = queue.poll();

                // 8방향으로 움직일 수 있음
                for (int j = 0; j < 8; j++) {
                    int nx = current.x + dx[j];
                    int ny = current.y + dy[j];

                    if (nx == targetX && ny == targetY) {
                        isFind = true;
                        sb.append(current.times + 1).append('\n');
                        break;
                    }

                    if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                        continue;
                    }

                    if (!visited[nx][ny]) {
                        queue.offer(new Point(nx, ny, current.times + 1));
                        visited[nx][ny] = true;
                    }
                }

                if (isFind) {
                    break;
                }
            }
        }

        System.out.println(sb.toString());
    }
}