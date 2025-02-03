// 정렬 - 두 용액

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class P2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;
        long[] result = new long[2];
        long sum = 2000000000L;

        while (left < right) {
            long temp = arr[left] + arr[right];
            if (Math.abs(temp) < Math.abs(sum)) {
                sum = temp;
                result[0] = arr[left];
                result[1] = arr[right];
            }

            if (temp < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}