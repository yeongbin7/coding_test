// Z - 골드 5
import java.io.*;
import java.util.*;

public class P1074 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(recursive(N, r, c));
    }

    static int recursive(int N, int r, int c) {
        if (N == 0) return 0;

        int half = (int) Math.pow(2, N - 1);

        if (r < half && c < half) return recursive(N - 1, r, c);
        if (r < half && c >= half) return half * half + recursive(N - 1, r, c - half);
        if (r >= half && c < half) return 2 * half * half + recursive(N - 1, r - half, c);
        return 3 * half * half + recursive(N - 1, r - half, c - half);
    }
}