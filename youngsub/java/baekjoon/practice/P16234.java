// 시뮬레이터 - 인구 이동
import java.io.*;
import java.util.*;

public class P16234 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        // 맵 초기화
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(process());
    }

    // 인구 이동 프로세스
    static int process() {
        int result = 0;
        boolean moved = true;

        while(moved) {
            moved = false;
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visited[i][j]) {
                        int populationSum = bfs(i, j);
                        if(populationSum > 0) moved = true;
                    }
                }
            }
            if(moved) result++;
        }
        return result;
    }

    // BFS로 연합 찾기
    static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        queue.offer(new int[]{x, y});
        union.add(new int[]{x, y});
        visited[x][y] = true;

        int sum = map[x][y];

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                // 인구이동이 일어날 수 있는지 체크
                int diff = Math.abs(map[current[0]][current[1]] - map[nx][ny]);

                if(diff >= L && diff <= R && !visited[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    union.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    sum += map[nx][ny];
                }
            }
        }

        // 연합이 형성되었다면 인구 이동 처리
        if(union.size() > 1) {
            int average = sum / union.size();
            for(int[] pos : union) {
                map[pos[0]][pos[1]] = average;
            }
            return sum;
        }

        return 0;
    }
}