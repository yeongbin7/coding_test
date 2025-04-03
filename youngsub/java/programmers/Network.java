// 네트워크 - 레벨 3
import java.util.*;

public class Network {

    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        arr = new ArrayList[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (computers[i][j] == 1) {
                    arr[i].add(j);
                    arr[j].add(i);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                bfs(i);
                answer++;
            }
        }

        return answer;
    }

    static void bfs(int number) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(number);
        visited[number] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : arr[current]) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}