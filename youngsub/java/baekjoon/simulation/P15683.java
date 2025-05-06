// 감시 - 골드 3
import java.io.*;
import java.util.*;

public class P15683 {

    static int N, M;
    static int[][] office;
    static ArrayList<CCTV> cctvList;
    static int minBlindSpot = Integer.MAX_VALUE;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][][] directions = {
            {},
            {{0}, {1}, {2}, {3}}, // 1번 CCTV - 4가지 방향
            {{0, 2}, {1, 3}},     // 2번 CCTV - 2가지 방향
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 CCTV - 4가지 방향
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번 CCTV - 4가지 방향
            {{0, 1, 2, 3}}  // 5번 CCTV - 1가지 방향
    };

    static class CCTV {
        int x, y; // 위치
        int type; // CCTV 종류 (1~5)

        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        office = new int[N][M];
        cctvList = new ArrayList<>();

        // 사무실 정보 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());

                // CCTV 발견 시 리스트에 추가
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvList.add(new CCTV(i, j, office[i][j]));
                }
            }
        }

        // 백트래킹 시작
        dfs(0, office);

        // 결과 출력
        System.out.println(minBlindSpot);
    }

    static void dfs(int depth, int[][] map) {
        // 모든 CCTV 방향을 결정했을 때
        if (depth == cctvList.size()) {
            int count = countBlindSpot(map);
            minBlindSpot = Math.min(minBlindSpot, count);
            return;
        }

        // 현재 처리할 CCTV
        CCTV cctv = cctvList.get(depth);

        // 현재 CCTV의 가능한 모든 방향 조합 시도
        for (int i = 0; i < directions[cctv.type].length; i++) {
            // 맵 복사
            int[][] newMap = copyMap(map);

            // 현재 방향 조합으로 감시 영역 표시
            for (int dir : directions[cctv.type][i]) {
                watch(newMap, cctv.x, cctv.y, dir);
            }

            // 다음 CCTV로 진행
            dfs(depth + 1, newMap);
        }
    }

    static void watch(int[][] map, int x, int y, int dir) {
        int nx = x;
        int ny = y;

        while (true) {
            nx += dx[dir];
            ny += dy[dir];

            // 맵 범위를 벗어나면 중단
            if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                break;
            }

            // 벽을 만나면 중단
            if (map[nx][ny] == 6) {
                break;
            }

            // 빈 칸이면 감시 영역으로 표시
            if (map[nx][ny] == 0) {
                map[nx][ny] = -1; // 감시 영역 표시
            }
            // CCTV가 있어도 통과 (감시 영역 표시 안함)
        }
    }

    static int[][] copyMap(int[][] original) {
        int[][] copy = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }

    static int countBlindSpot(int[][] map) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}