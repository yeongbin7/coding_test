// DFS와 BFS - 실버 2
import java.io.*;
import java.util.*;

public class P1260 {

    static int N, M, V;

    static StringBuilder sb;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arr[start].add(end);
            arr[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(arr[i]);
        }

        visited = new boolean[N + 1];
        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb.toString().trim());

        visited = new boolean[N + 1];
        sb = new StringBuilder();
        bfs(V);
        System.out.println(sb.toString().trim());
    }

    static void dfs(int number) {
        visited[number] = true;
        sb.append(number).append(' ');
        for (int next : arr[number]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    static void bfs(int number) {
        Queue<Integer> queue = new LinkedList<>();
        visited[number] = true;
        queue.offer(number);

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now).append(' ');
            for (int next : arr[now]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}