// 쿼드트리 - 실버 1
import java.io.*;
import java.util.*;

public class P1992 {

    static int N;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        recursive(N, 0, 0);
        System.out.println(sb);
    }

    static void recursive(int size, int row, int col) {
        if (size == 1) {
            if (arr[row][col] == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            return;
        }

        int standard = arr[row][col];
        boolean isSame = true;

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != standard) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        if (isSame) {
            sb.append(standard);
            return;
        }

        sb.append("(");
        int newSize = size / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                recursive(newSize, row + i * newSize, col + j * newSize);
            }
        }
        sb.append(")");
    }
}