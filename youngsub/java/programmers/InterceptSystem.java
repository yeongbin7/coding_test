import java.util.*;

public class InterceptSystem {

    public int solution(int[][] targets) {
        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        int count = 0;
        double lastShot = 0;

        for (int[] target : targets) {
            int start = target[0];
            int end = target[1];

            if (start >= lastShot) {
                count++;
                lastShot = end - 0.1;
            }
        }

        return count;
    }
}