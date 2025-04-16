// 부분수열의 합 - 실버 2
import java.io.*;
import java.util.*;

public class P1182 {

    static int N, S;
    static int answer = 0;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        backtracking(0, 0);
        System.out.println(S == 0 ? answer - 1 : answer);
    }

    static void backtracking(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                answer++;
            }
            return;
        }

        backtracking(depth + 1, sum + arr[depth]);
        backtracking(depth + 1, sum);
    }
}