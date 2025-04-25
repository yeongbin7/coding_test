// 암호 만들기 - 골드 5
import java.io.*;
import java.util.*;

public class P1759 {

    static int L, C;
    static char[] arr;
    static char[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        result = new char[L];
        arr = new char[C];
        visited = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        backtracking(0, 0);
        System.out.println(sb);
    }

    static void backtracking(int depth, int start) {
        if (depth == L) {
            boolean isVowel = false;
            int consonantCount = 0;
            for (char c : result) {
                if (isVowel(c)) {
                    isVowel = true;
                } else {
                    consonantCount++;
                }

                if (isVowel && consonantCount >= 2) break;
            }

            if (isVowel && consonantCount >= 2) {
                for (char c : result) {
                    sb.append(c);
                }
                sb.append('\n');
                return;
            }

            return;
        }

        for (int i = start; i < C; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                backtracking(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }

        return false;
    }
}