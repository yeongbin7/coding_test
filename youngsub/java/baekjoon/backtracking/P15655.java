// N과 M (6) - 실버 3
import java.io.*;
import java.util.*;

public class P15655 {

    static int[] answer;
    static int[] arr;
    static boolean[] visited;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visited = new boolean[N];
        answer = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backtracking(0, 0);

        System.out.println(sb);
    }

    static void backtracking(int depth, int start) {
        if (depth == M) {
            for (int i : answer) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = arr[i];
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}