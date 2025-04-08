// 하노이 탑 이동 순서 - 골드 5
import java.util.*;

public class P11729 {

    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        hanoi(N, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb);
    }

    static void hanoi(int N, int start, int mid, int to) {
        count++;

        if (N == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        hanoi(N - 1, start, to, mid);

        sb.append(start + " " + to + "\n");

        hanoi(N - 1, mid, start, to);
    }
}