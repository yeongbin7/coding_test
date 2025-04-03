// N과 M (1)
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15649 {

    static int N;
    static int M;
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];
        answer = new int[M];

        backtracking(0);
    }

    private static void backtracking(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(answer[i]).append(' ');
            }
            System.out.println(sb.toString());
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer[depth] = i;  // 현재 깊이에 i 값을 저장
                backtracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}