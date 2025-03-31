// 벽 부수고 이동하기 - 골드 3
import java.io.*;
import java.util.*;

public class P2206 {

    static class Point {
        int x, y, moveCount, breakCount;

        public Point(int x, int y, int moveCount, int breakCount) {
            this.x = x;
            this.y = y;
            this.moveCount = moveCount;
            this.breakCount = breakCount;
        }
    }

    static int N, M;

    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
    }

    static void bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY, 1, 0));
        visited[startX][startY][0] = true;

        boolean isArrived = false;
        int moveCount = 0;
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                isArrived = true;
                moveCount = cur.moveCount;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (map[nx][ny] == 1) {
                    if (cur.breakCount == 0 && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        queue.offer(new Point(nx, ny, cur.moveCount + 1, 1));
                    }
                } else {
                    if (!visited[nx][ny][cur.breakCount]) {
                        visited[nx][ny][cur.breakCount] = true;
                        queue.offer(new Point(nx, ny, cur.moveCount + 1, cur.breakCount));
                    }
                }
            }
        }

        if (isArrived) {
            System.out.println(moveCount);
        } else {
            System.out.println(-1);
        }
    }
}