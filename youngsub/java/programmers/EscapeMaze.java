import java.util.*;

public class EscapeMaze {
    static class Point {
        int x, y, distance;

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public int solution(String[] maps) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        char[][] map = new char[maps.length][maps[0].length()];
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Queue<Point> queue = new LinkedList<>();
        int answer = -1;
        int leverX = -1, leverY = -1;
        int leverDistance = -1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    queue.offer(new Point(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }

        // 레버 찾기
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (map[now.x][now.y] == 'L') {
                leverX = now.x;
                leverY = now.y;
                leverDistance = now.distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;

                if (!visited[nx][ny] && map[nx][ny] != 'X') {
                    queue.offer(new Point(nx, ny, now.distance + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        // 레버를 찾지 못한 경우
        if (leverX == -1) return -1;

        // 레버에서 출구로 출발
        queue.clear();
        queue.offer(new Point(leverX, leverY, 0));
        visited = new boolean[maps.length][maps[0].length()];
        visited[leverX][leverY] = true;  // 레버 위치 방문 표시

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            if (map[now.x][now.y] == 'E') {
                answer = leverDistance + now.distance;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length) continue;

                if (!visited[nx][ny] && map[nx][ny] != 'X') {
                    queue.offer(new Point(nx, ny, now.distance + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return answer;
    }
}