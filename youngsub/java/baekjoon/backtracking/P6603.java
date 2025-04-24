// 로또 - 실버 2
import java.io.*;
import java.util.*;

public class P6603 {

    static int K;
    static int[] result;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            if (K == 0) break;
            result = new int[6];
            arr = new int[K];
            visited = new boolean[K];

            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            backtracking(0, 0);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static void backtracking(int depth, int start) {
        if (depth == 6) {
            for (int i : result) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}