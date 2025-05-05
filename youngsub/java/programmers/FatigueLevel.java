import java.util.*;

public class FatifueLevel {

    int answer = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];

        dfs(0, k, dungeons, visited);

        return answer;
    }

    public void dfs(int visitedCount, int remainedK, int[][] dungeons, boolean[] visited) {

        answer = Math.max(answer, visitedCount);

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && remainedK >= dungeons[i][0]) {
                visited[i] = true;
                dfs(visitedCount + 1, remainedK - dungeons[i][1], dungeons, visited);
                visited[i] = false;
            }
        }
    }
}