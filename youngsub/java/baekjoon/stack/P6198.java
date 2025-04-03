// 옥상 정원 꾸미기 - 골드 5
import java.util.Scanner;
import java.util.Stack;

public class P6198 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] heights = new int[N];

        for (int i = 0; i < N; i++) {
            heights[i] = sc.nextInt();
        }

        // 높이만 저장
        Stack<Integer> stack = new Stack<>();
        long result = 0;

        for (int i = 0; i < N; i++) {

            while (!stack.isEmpty() && stack.peek() <= heights[i]) {
                stack.pop();
            }

            // 스택에 남아있는 건물 수 = 현재 건물을 볼 수 있는 건물 수
            result += stack.size();

            // 현재 건물 스택에 추가
            stack.push(heights[i]);
        }
    }
}