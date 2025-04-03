// 시뮬레이션 - 톱니바퀴

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class P14891 {

    static LinkedList<Integer> cogwheel1 = new LinkedList<>();
    static LinkedList<Integer> cogwheel2 = new LinkedList<>();
    static LinkedList<Integer> cogwheel3 = new LinkedList<>();
    static LinkedList<Integer> cogwheel4 = new LinkedList<>();
    static int[] rotateDirection = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            cogwheel1.addLast(line.charAt(i) - '0');
        }
        line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            cogwheel2.addLast(line.charAt(i) - '0');
        }
        line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            cogwheel3.addLast(line.charAt(i) - '0');
        }
        line = br.readLine();
        for (int i = 0; i < line.length(); i++) {
            cogwheel4.addLast(line.charAt(i) - '0');
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int targetCogwheel = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());

            process(targetCogwheel, direction);
        }

        System.out.println(cogwheel1.get(0) + (cogwheel2.get(0) * 2) + (cogwheel3.get(0) * 4) + (cogwheel4.get(0) * 8));
    }

    private static void process(int cogwheel, int direction) {
        Arrays.fill(rotateDirection, 0);

        cogwheel -= 1;
        rotateDirection[cogwheel] = direction;

        // 왼쪽 톱니바퀴들 검사
        for (int i = cogwheel; i > 0; i--) {
            if (getCogValue(i, 6) != getCogValue(i-1, 2)) {
                // 전 회전에서 반대방향으로만 회전됨
                rotateDirection[i-1] = -rotateDirection[i];
            } else {
                break;
            }
        }

        // 오른쪽 톱니바퀴들 검사
        for (int i = cogwheel; i < 3; i++) {
            if (getCogValue(i, 2) != getCogValue(i+1, 6)) {
                // 전 회전에서 반대방향으로만 회전됨
                rotateDirection[i+1] = -rotateDirection[i];
            } else {
                break;
            }
        }

        // 모든 톱니바퀴 한번에 회전
        for (int i = 0; i < 4; i++) {
            if (rotateDirection[i] == 1) {
                rotateCogwheelRight(i);
            } else if (rotateDirection[i] == -1) {
                rotateCogwheelLeft(i);
            }
        }
    }

    private static int getCogValue(int cogIdx, int pos) {
        switch(cogIdx) {
            case 0: return cogwheel1.get(pos);
            case 1: return cogwheel2.get(pos);
            case 2: return cogwheel3.get(pos);
            case 3: return cogwheel4.get(pos);
            default: return -1;
        }
    }

    private static void rotateCogwheelRight(int cogIdx) {
        switch(cogIdx) {
            case 0: cogwheel1.addFirst(cogwheel1.pollLast()); break;
            case 1: cogwheel2.addFirst(cogwheel2.pollLast()); break;
            case 2: cogwheel3.addFirst(cogwheel3.pollLast()); break;
            case 3: cogwheel4.addFirst(cogwheel4.pollLast()); break;
        }
    }

    private static void rotateCogwheelLeft(int cogIdx) {
        switch(cogIdx) {
            case 0: cogwheel1.addLast(cogwheel1.pollFirst()); break;
            case 1: cogwheel2.addLast(cogwheel2.pollFirst()); break;
            case 2: cogwheel3.addLast(cogwheel3.pollFirst()); break;
            case 3: cogwheel4.addLast(cogwheel4.pollFirst()); break;
        }
    }
}