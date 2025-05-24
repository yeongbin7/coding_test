public class Capet {

    public int[] solution(int brown, int yellow) {
        int halfYellowLength = (brown - 4) / 2;

        for (int i = 1; i <= halfYellowLength - 1; i++) {
            int j = halfYellowLength - i;
            if (j > 0 && i * j == yellow && i >= j) {
                return new int[]{i + 2, j + 2};
            }
        }

        return new int[]{0, 0};
    }

}