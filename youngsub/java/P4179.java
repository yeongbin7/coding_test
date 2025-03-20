// 불!
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class P4179 {

    static int R, C;
    static char[][] map;
    static int[][] fireMap;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static class Point {
        int x, y, time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fireMap = new int[R][C];
        Queue<Point> fireQueue = new LinkedList<>();
        Point jihoon = null;

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                fireMap[i][j] = Integer.MAX_VALUE;
                if (map[i][j] == 'F') {
                    fireQueue.offer(new Point(i, j, 0));
                    fireMap[i][j] = 0;
                } else if (map[i][j] == 'J') {
                    jihoon = new Point(i, j, 0);
                }
            }
        }

        while (!fireQueue.isEmpty()) {
            Point cur = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                if (map[nx][ny] != '#' && fireMap[nx][ny] == Integer.MAX_VALUE) {
                    fireMap[nx][ny] = cur.time + 1;
                    fireQueue.offer(new Point(nx, ny, cur.time + 1));
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        queue.offer(jihoon);
        visited[jihoon.x][jihoon.y] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.x == 0 || cur.x == R - 1 || cur.y == 0 || cur.y == C - 1) {
                System.out.println(cur.time + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] != '#' && cur.time + 1 < fireMap[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, cur.time + 1));
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}