public class JumpAndTeleport {
    public int solution(int n) {
        int ans = 0;

        while (true) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }

            if (n == 0) break;
        }

        return ans;
    }
}