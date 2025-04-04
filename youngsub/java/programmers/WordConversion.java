// 단어 변환 - 레벨 3
import java.util.*;

public class WordConversion {
    public int solution(String begin, String target, String[] words) {
        boolean isExist = false;
        for (String word : words) {
            if (word.equals(target)) {
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            return 0;
        }

        boolean[] visited = new boolean[words.length];
        return dfs(begin, target, words, visited, 0);
    }

    static int dfs(String word, String target, String[] words, boolean[] visited, int times) {
        if (word.equals(target)) {
            return times;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (visited[i]) continue;

            if (canConvert(word, words[i])) {
                visited[i] = true;
                int result = dfs(words[i], target, words, visited, times + 1);
                if (result != Integer.MAX_VALUE) {
                    min = Math.min(min, result);
                }
                visited[i] = false;
            }
        }

        return min;
    }

    static boolean canConvert(String word1, String word2) {
        int diffCount = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) diffCount++;
        }

        return diffCount == 1;
    }
}