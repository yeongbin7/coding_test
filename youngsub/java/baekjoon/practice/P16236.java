// 16236 - 시뮬레이터 - 아기 상어

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class P16236 {

    static class Fish {
        int x, y, size;

        public Fish(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        Map<Integer, List<Fish>> fishMap = new HashMap<>();
        Fish shark = null;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    // 상어 세팅
                    shark = new Fish(i, j, 2);
                    // 상어의 위치를 변경
                    map[i][j] = 0;
                } else if (map[i][j] >= 1 && map[i][j] <= 6) {
                    // 키값이 사이즈인 맵에 물고기 세팅
                    List<Fish> list = fishMap.get(map[i][j]);
                    if (list == null) {
                        fishMap.put(map[i][j], new ArrayList<>());
                    }
                    fishMap.get(map[i][j]).add(new Fish(i, i, map[i][j]));
                }
            }
        }

        // 상어의 이동횟수
        int moveCount = 0;
        int eatCount = 0;

        while (true) {
            int[] next = findNextFish(map, shark, fishMap);
            if (next == null) break;

            int distance = next[2];
            moveCount += distance;

            // 물고기 먹기
            eatCount++;
            if (eatCount == shark.size) {
                shark.size++;
                eatCount = 0;
            }

            // 상어 위치 업데이트
            shark.x = next[0];
            shark.y = next[1];

            int fishSize = map[next[0]][next[1]];
            map[next[0]][next[1]] = 0;
            List<Fish> fishes = fishMap.get(fishSize);
            for (int i = 0; i < fishes.size(); i++) {
                Fish fish = fishes.get(i);
                if (fish.x == next[0] && fish.y == next[1]) {
                    fishes.remove(i);
                    break;  // 물고기를 찾아서 제거했으면 반복문 종료
                }
            }
        }

        System.out.println(moveCount);
    }

    // BFS로 먹을 수 있는 물고기 찾기
    private static int[] findNextFish(int[][] map, Fish shark, Map<Integer, List<Fish>> fishMap) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        // 현재 상어의 위치와 이동거리 큐에 삽입
        queue.offer(new int[]{shark.x, shark.y, 0});
        visited[shark.x][shark.y] = true;

        // 최단거리와 그때의 물고기 위치 저장할 변수 초기화
        int minDist = Integer.MAX_VALUE; // 먹을 수 있는 물고기까지 최단거리
        int targetX = -1;
        int targetY = -1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            // 이미 찾은 최단거리보다 현재 거리가 크다면 더이상 의미 없음
            if (dist > minDist) break;

            // 먹을 수 있는 물고기
            if (map[x][y] > 0 && map[x][y] < shark.size) {
                if (dist < minDist) {
                    minDist = dist;
                    targetX = x;
                    targetY = y;
                } else if (dist == minDist) {
                    // 거리가 같으면 위쪽, 왼쪽에 있는 물고기 선택
                    if (x < targetX || (x == targetX && y < targetY)) {
                        targetX = x;
                        targetY = y;
                    }
                }
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (visited[nx][ny] || map[nx][ny] > shark.size) continue;

                queue.offer(new int[]{nx, ny, dist + 1});
                visited[nx][ny] = true;
            }
        }

        return minDist == Integer.MAX_VALUE ? null : new int[]{targetX, targetY, minDist};
    }

}