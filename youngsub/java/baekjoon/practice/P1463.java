// 1로 만들기
import java.util.Scanner;

public class P1463 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        // dp[i] = i를 1로 만드는데 필요한 최소 연산 횟수
        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[1] = 0; // 1은 이미 1이므로 연산 필요 없음

        // 2부터 n까지 최소 연산 횟수 계산
        for (int i = 2; i <= n; i++) {
            // 3가지 연산 중에서 최소값을 선택
            // 1을 빼는 연산
            dp[i] = dp[i - 1] + 1;

            // 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}