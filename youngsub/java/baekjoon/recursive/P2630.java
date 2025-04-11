// 색종이 만들기 - 실버 2
import java.io.*;
import java.util.*;

public class P2630 {

    static int[][] arr;

    static int N;
    static int whitePaper = 0;
    static int bluePaper = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursive(N, 0, 0);
        System.out.println(whitePaper);
        System.out.println(bluePaper);
    }

    static void recursive(int size, int row, int col) {
        if (size == 1) {
            if (arr[row][col] == 1) {
                bluePaper++;
            } else {
                whitePaper++;
            }
            return;
        }

        int standard = arr[row][col];
        boolean isSame = true;
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (standard != arr[i][j]) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        if (isSame) {
            if (standard == 1) {
                bluePaper++;
            } else {
                whitePaper++;
            }
            return;
        } else {
            recursive(size / 2, row, col);
            recursive(size / 2, row, col + size / 2);
            recursive(size / 2, row + size / 2, col + size / 2);
            recursive(size / 2, row + size / 2, col);
        }
    }

}