// 소프티어 - 바이러스

import java.io.*;
import java.util.*;

public class Virus {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        for (long i = 0; i < N; i++) {
            K = K * P % 1000000007;
        }

        System.out.println(K);
    }
}
