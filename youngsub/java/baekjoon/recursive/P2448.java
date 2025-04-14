// 별 찍기 11 - 골드 4
import java.util.*;

public class P2448 {

    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], ' ');
        }

        recursive(N, 0, 0);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    static void recursive(int size, int row, int col) {
        if (size == 3) {
            arr[row][col + 2] = '*';               // 첫 번째 줄 가운데
            arr[row + 1][col + 1] = '*';           // 두 번째 줄 왼쪽
            arr[row + 1][col + 3] = '*';           // 두 번째 줄 오른쪽
            for (int j = 0; j < 5; j++) {          // 세 번째 줄 전체
                arr[row + 2][col + j] = '*';
            }
            return;
        }

        int newSize = size / 2;
        // 위쪽 삼각형
        recursive(newSize, row, col + newSize);
        // 아래쪽 왼쪽 삼각형
        recursive(newSize, row + newSize, col);
        // 아래쪽 오른쪽 삼각형
        recursive(newSize, row + newSize, col + size);
    }
}