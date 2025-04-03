// 구현 - 그룹 단어 체커

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (isGroupWord(br.readLine())) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean isGroupWord(String str) {
        boolean[] used = new boolean[26];  // 알파벳 사용 여부를 체크할 배열
        int prevChar = 0;  // 이전 문자 (첫 비교를 위해 0으로 초기화)

        for(int i = 0; i < str.length(); i++) {
            int currentChar = str.charAt(i);

            // 이전 문자와 다른 문자가 나왔을 때
            if(prevChar != currentChar) {
                // 이미 사용된 문자라면 그룹 단어가 아님
                if(used[currentChar - 'a']) {
                    return false;
                } else {
                    used[currentChar - 'a'] = true;  // 문자 사용 체크
                    prevChar = currentChar;  // 이전 문자 업데이트
                }
            }
        }

        return true;
    }
}