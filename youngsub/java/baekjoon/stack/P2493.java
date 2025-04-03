// 탑 - 골드5
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;


public class P2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] heights = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        // [탑의 인덱스, 탑의 높이]
        Stack<int[]> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            // 현재 탑보다 낮은 탑들은 모두 제거(수신을 못하기 때문)
            while (!stack.isEmpty() && stack.peek()[1] < heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append("0 ");
            } else {
                sb.append((stack.peek()[0] + 1) + " ");
            }

            stack.push(new int[]{i, heights[i]});
        }

        System.out.println(sb.toString());
    }
}