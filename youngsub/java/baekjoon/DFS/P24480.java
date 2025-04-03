// 알고리즘 수업 - 깊이 우선 탐색 2
import java.io.*;
import java.util.*;

public class P24480 {

    static int N, M, R;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    static int[] order; // 정점 방문 순서를 저장할 배열
    static int count = 0; // 방문 순서를 카운트할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1]; // 방문 순서 초기화

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
            Collections.sort(arr[i], (a, b) -> {
                return Integer.compare(b, a);
            });
        }

        dfs(R);

        // 각 정점의 방문 순서 출력
        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append('\n');
        }

        System.out.println(sb);
    }

    static void dfs(int number) {
        visited[number] = true;
        count++; // 방문 순서 증가
        order[number] = count; // 현재 정점의 방문 순서 저장

        for (int next : arr[number]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}