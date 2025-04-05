// 무인도 여행 - 레벨 2
import java.util.*;

public class TripDesertIsland {

    static int n, m;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;

    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];

        // 맵 초기화
        for (int i = 0; i < n; i++) {
            String line = maps[i];
            for (int j = 0; j < m; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] != 'X') {
                    list.add(bfs(i, j));
                }
            }
        }

        if (list.isEmpty()) {
            return new int[] {-1};
        } else {
            Collections.sort(list);
            int[] answer = new int[list.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = list.get(i);
            }
            return answer;
        }
    }

    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.offer(new int[]{startX, startY});
        int count = map[startX][startY] - '0';

        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny] && map[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    count += map[nx][ny] - '0';
                }
            }
        }

        return count;
    }
}