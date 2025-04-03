// 상범 빌딩 - 골드 5
import java.io.*;
import java.util.*;

public class P6593 {

    static class Point {
        int x, y, z, times;

        public Point(int x, int y, int z, int times) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.times = times;
        }
    }

    static int L, R, C;

    static char[][][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            int endX = 0;
            int endY = 0;
            int endZ = 0;

            map = new char[R][C][L];
            visited = new boolean[R][C][L];

            Queue<Point> queue = new LinkedList<>();
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[j][k][i] = line.charAt(k);

                        if (map[j][k][i] == 'S') {
                            queue.offer(new Point(j, k, i, 0));
                            visited[j][k][i] = true;
                        } else if (map[j][k][i] == 'E') {
                            endX = j;
                            endY = k;
                            endZ = i;
                        }
                    }
                }
                br.readLine();
            }

            boolean escaped = false;
            while (!queue.isEmpty()) {
                Point cur = queue.poll();

                if (cur.x == endX && cur.y == endY && cur.z == endZ) {
                    escaped = true;
                    sb.append("Escaped in " + cur.times + " minute(s).\n");
                    break;
                }

                for (int i = 0; i < 6; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    int nz = cur.z + dz[i];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C || nz < 0 || nz >= L) {
                        continue;
                    }

                    if (!visited[nx][ny][nz] && map[nx][ny][nz] != '#') {
                        queue.offer(new Point(nx, ny, nz, cur.times + 1));
                        visited[nx][ny][nz] = true;
                    }
                }
            }

            if (!escaped) {
                sb.append("Trapped!\n");
            }
        }

        System.out.println(sb.toString());
    }
}