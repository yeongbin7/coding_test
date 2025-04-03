// 부분수열의 합
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class P1182 {

    static int N, S;
    static int count = 0;
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

        // 백트래킹으로 모든 부분수열 확인
        backtracking(0, 0);

        // 공집합의 경우 1 빼줌
        System.out.println(S == 0 ? count - 1 : count);
    }

    static void backtracking(int index, int sum) {
        if (index == N) {
            if (sum == S) {
                count++;
            }
            return;
        }

        // 현재 원소를 더함
        backtracking(index + 1, sum + arr[index]);

        // 현재 원소를 더하지 않음
        backtracking(index + 1, sum);
    }
}