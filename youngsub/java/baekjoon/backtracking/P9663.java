// N-Queen - 골드 4
import java.util.*;

public class P9663 {

    static int N;
    static int result = 0;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        map = new int[N][N];

        nQueen(0);
        System.out.println(result);
    }

    static void nQueen(int row) {
        if (row == N) {
            result++;
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isPossible(row, col)) {
                map[row][col] = 1;
                nQueen(row + 1);
                map[row][col] = 0; // 백트래킹
            }
        }
    }

    static boolean isPossible(int row, int col) {
        // 같은 열에 퀸이 있는지 확인
        for (int i = 0; i < row; i++) {
            if (map[i][col] == 1) {
                return false;
            }
        }

        // 왼쪽 위 대각선 확인
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (map[i][j] == 1) {
                return false;
            }
        }

        // 오른쪽 위 대각선 확인
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (map[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}