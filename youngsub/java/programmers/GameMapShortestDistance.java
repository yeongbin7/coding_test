// 게임 맵 최단 거리 - 레벨 2
import java.util.*;

public class GameMapShortestDistance {

    static class Point {
        int x, y, times;

        public Point (int x, int y, int times) {
            this.x = x;
            this.y = y;
            this.times = times;
        }
    }

    public int solution(int[][] maps) {

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        boolean[][] visited = new boolean[maps.length][maps[0].length];

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.x == maps.length - 1 && cur.y == maps[0].length -1) {
                return cur.times;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) continue;

                if (!visited[nx][ny] && maps[nx][ny] == 1) {
                    queue.offer(new Point(nx, ny, cur.times + 1));
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;

    }
}