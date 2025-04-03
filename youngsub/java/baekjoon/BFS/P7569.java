// 토마토 - 골드 5
import java.io.*;
import java.util.*;

public class P7569 {

    static int N, M, H;

    static int[][][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 가로의 길이
        M = Integer.parseInt(st.nextToken());
        // 세로의 길이
        N = Integer.parseInt(st.nextToken());
        // 높이
        H = Integer.parseInt(st.nextToken());

        map = new int[N][M][H];
        visited = new boolean[N][M][H];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[j][k][i] = Integer.parseInt(st.nextToken());
                    if (map[j][k][i] == 1) {
                        queue.offer(new int[]{j, k, i});
                        visited[j][k][i] = true;
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                int nz = current[2] + dz[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H) {
                    continue;
                }

                if (!visited[nx][ny][nz] && map[nx][ny][nz] == 0) {
                    queue.offer(new int[]{nx, ny, nz});
                    visited[nx][ny][nz] = true;
                    map[nx][ny][nz] = map[current[0]][current[1]][current[2]] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < H; k++) {
                    if (map[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    answer = Math.max(answer, map[i][j][k]);
                }
            }
        }

        // 시작이 1이기 때문에
        System.out.println(answer - 1);
    }
}