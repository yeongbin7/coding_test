// N 과 M (2) - 실버 3
import java.io.*;
import java.util.*;

public class P15650 {

    static int N, M;
    static boolean[] visited;
    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        arr = new int[M];

        backtracking(0);
        System.out.println(sb);
    }

    static void backtracking(int depth) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                if (depth >= 1 && arr[depth - 1] > i) {
                    continue;
                }
                visited[i] = true;
                arr[depth] = i;
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}