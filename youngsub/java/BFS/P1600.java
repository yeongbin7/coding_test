// 말이 되고픈 원숭이 - 골드 3
import java.io.*;
import java.util.*;

public class P1600 {

    static class Monkey {
        int x, y, times, moveCount;

        public Monkey(int x, int y, int times, int moveCount) {
            this.x = x;
            this.y = y;
            this.times = times;
            this.moveCount = moveCount;
        }
    }

    static int K, W, H;

    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] dhx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dhy = {-1, 1, -2, 2, -2, 2, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int startX, int startY) {
        Queue<Monkey> queue = new LinkedList<>();
        queue.offer(new Monkey(startX, startY, 0, 0));
        visited[startX][startY][0] = true;

        while (!queue.isEmpty()) {
            Monkey cur = queue.poll();

            if (cur.x == H - 1 && cur.y == W - 1) {
                return cur.moveCount;
            }

            // 말처럼 뛸 수 있는지
            if (cur.times < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = cur.x + dhx[i];
                    int ny = cur.y + dhy[i];

                    if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;

                    if (!visited[nx][ny][cur.times + 1] && map[nx][ny] == 0) {
                        queue.offer(new Monkey(nx, ny, cur.times + 1, cur.moveCount + 1));
                        visited[nx][ny][cur.times + 1] = true;
                    }
                }
            }

            // 항상 일반 이동을 고려
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W) continue;

                if (!visited[nx][ny][cur.times] && map[nx][ny] == 0) {
                    queue.offer(new Monkey(nx, ny, cur.times, cur.moveCount + 1));
                    visited[nx][ny][cur.times] = true;
                }
            }
        }

        return -1;
    }
}