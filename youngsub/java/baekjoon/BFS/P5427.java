// 불 - 골드 4
import java.io.*;
import java.util.*;

public class P5427 {

    static class Point {
        int x, y, times;

        public Point(int x, int y, int times) {
            this.x = x;
            this.y = y;
            this.times = times;
        }
    }

    static int N, M;

    static char[][] map;
    static int[][] fireMap;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            fireMap = new int[N][M];
            visited = new boolean[N][M];

            Point sanggeun;
            Queue<int[]> fireQueue = new LinkedList<>();
            Queue<Point> queue = new LinkedList<>();
            for (int j = 0; j < N; j++) {
                String line = br.readLine();
                for (int k = 0; k < M; k++) {
                    map[j][k] = line.charAt(k);
                    fireMap[j][k] = Integer.MAX_VALUE;
                    if (map[j][k] == '#') {
                        fireMap[j][k] = -1;
                    } else if (map[j][k] == '*') {
                        fireMap[j][k] = 0;
                        fireQueue.offer(new int[]{j, k});
                    } else if (map[j][k] == '@') {
                        sanggeun = new Point(j, k, 0);
                        queue.offer(sanggeun);
                        visited[j][k] = true;
                    }
                }
            }

            // 불 퍼트리기
            while (!fireQueue.isEmpty()) {
                int[] current = fireQueue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = current[0] + dx[j];
                    int ny = current[1] + dy[j];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (fireMap[nx][ny] == Integer.MAX_VALUE) {
                        fireQueue.offer(new int[]{nx, ny});
                        fireMap[nx][ny] = fireMap[current[0]][current[1]] + 1;
                    }
                }
            }

            boolean isPossible = false;
            int moveCount = 0;
            while (!queue.isEmpty()) {
                Point current = queue.poll();

                if (current.x == 0 || current.x == N - 1 || current.y == 0 || current.y == M - 1) {
                    moveCount = current.times + 1;
                    isPossible = true;
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = current.x + dx[j];
                    int ny = current.y + dy[j];

                    if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                        continue;
                    }

                    if (!visited[nx][ny] && map[nx][ny] == '.' && current.times + 1 < fireMap[nx][ny]) {
                        queue.offer(new Point(nx, ny, current.times + 1));
                        visited[nx][ny] = true;
                    }
                }
            }

            if (isPossible) {
                sb.append(moveCount).append('\n');
            } else {
                sb.append("IMPOSSIBLE").append('\n');
            }
        }

        System.out.println(sb.toString());
    }
}