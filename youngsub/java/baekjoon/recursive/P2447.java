// 별 찍기 - 10 - 골드 5
import java.util.*;

public class P2447 {

    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new char[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');
        }

        recursive(N, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void recursive(int size, int row, int col) {
        if (size == 3) {
            for (int i = row; i < row + 3; i++) {
                for (int j = col; j < col + 3; j++) {
                    if (i != row + 1|| j != col + 1) {
                        arr[i][j] = '*';
                    }
                }
            }
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                recursive(newSize, row + i * newSize, col + j * newSize);
            }
        }
    }
}