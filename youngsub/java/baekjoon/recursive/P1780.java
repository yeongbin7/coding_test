// 종이의 개수 - 실버 2
import java.io.*;
import java.util.*;

public class P1780 {

    static int N;
    static int zeroCount = 0;
    static int plusCount = 0;
    static int minusCount = 0;

    static int[][] arr;

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
        System.out.println(minusCount);
        System.out.println(zeroCount);
        System.out.println(plusCount);
    }

    static void recursive(int size, int row, int col) {
        if (size == 1) {
            if (arr[row][col] == -1) {
                minusCount++;
            } else if (arr[row][col] == 0) {
                zeroCount++;
            } else {
                plusCount++;
            }
            return;
        }

        // 구역이 모두 같은 수 인지 체크 하는 로직
        int target = arr[row][col];
        boolean isSame = true;
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != target) {
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        if (isSame) {
            if (target == -1) {
                minusCount++;
            } else if (target == 0) {
                zeroCount++;
            } else {
                plusCount++;
            }
            return;
        }

        // 아니면 재귀 호출
        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                recursive(newSize, row + i * newSize, col + j * newSize);
            }
        }
    }
}