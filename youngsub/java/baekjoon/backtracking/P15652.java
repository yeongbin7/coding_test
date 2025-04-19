// N과 M (4) - 실버 3
import java.io.*;
import java.util.*;

public class P15652 {

    static int N, M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        backtracking(0);

        System.out.println(sb.toString());
    }

    private static void backtracking(int depth) {
        if (M == depth) {
            for (int i : arr) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            if (depth >= 1) {
                if (arr[depth] < arr[depth - 1]) continue;
            }
            backtracking(depth + 1);
        }
    }
}