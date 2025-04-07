// 곱셈 - 살버 1
import java.io.*;
import java.util.*;

public class P1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    public static long pow(long base, long exp, long mod) {
        if (exp == 0) {
            return 1;
        }

        long half = pow(base, exp / 2, mod);

        if (exp % 2 == 0) {
            return (half * half) % mod;
        } else {
            return (((half * half) % mod) * base) % mod;
        }
    }
}