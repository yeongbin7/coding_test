// 불! - 골드 3
import java.io.*;
import java.util.*;

public class P4179 {

    static class Point {
        int x, y, time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int n, m;

    static char[][] map;
    static int[][] fireMap;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        fireMap = new int[n][m];

        Point jihoon = null;

        Queue<Point> fireQueue = new LinkedList<>();
        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
                fireMap[i][j] = Integer.MAX_VALUE;
                if (map[i][j] == '#') {
                    fireMap[i][j] = -1;
                } else if (map[i][j] == 'F') {
                    fireQueue.offer(new Point(i, j, 0));
                    fireMap[i][j] = 0;
                } else if (map[i][j] == 'J') {
                    jihoon = new Point(i, j, 0);
                    queue.offer(jihoon);
                    visited[i][j] = true;
                }
            }
        }

        while (!fireQueue.isEmpty()) {
            Point current = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (map[nx][ny] != '#' && fireMap[nx][ny] == Integer.MAX_VALUE) {
                    fireMap[nx][ny] = current.time + 1;
                    fireQueue.offer(new Point(nx, ny, current.time + 1));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                // 현재 위치가 모서리이면
                if (current.x == 0 || current.x == n - 1 || current.y == 0 || current.y == m - 1) {
                    System.out.println(current.time + 1);
                    return;
                }

                // 맵 범위 밖이면 패쓰
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] != '#' && current.time + 1 < fireMap[nx][ny]) {
                    queue.offer(new Point(nx, ny, current.time + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}