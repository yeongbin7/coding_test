public class ContinuousSubsequenceSum {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int currentSum = sequence[0];
        int minLength = Integer.MAX_VALUE;
        int[] answer = new int[2];
        while (start < sequence.length) {
            if (currentSum == k) {
                int length = end - start + 1;
                if (length < minLength) {
                    minLength = length;
                    answer[0] = start;
                    answer[1] = end;
                }
                // start 포인터 이동 (구간 축소)
                currentSum -= sequence[start];
                start++;
            }
            // 현재 합이 k보다 작고 end를 증가시킬 수 있으면
            else if (currentSum < k && end < sequence.length - 1) {
                // end 포인터 이동 (구간 확장)
                end++;
                currentSum += sequence[end];
            }
            // 현재 합이 k보다 크거나, 더 이상 end를 증가시킬 수 없으면
            else {
                // start 포인터 이동 (구간 축소)
                currentSum -= sequence[start];
                start++;
            }
        }

        return answer;
    }
}