// 타겟 넘버 - 레벨 2
public class TargetNumber {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, 0, 0, target);
    }

    private int dfs(int[] numbers, int depth, int sum, int target) {
        if (depth == numbers.length) {
            return sum == target ? 1 : 0;
        }

        int count = 0;
        count += dfs(numbers, depth + 1, sum + numbers[depth], target);
        count += dfs(numbers, depth + 1, sum - numbers[depth], target);

        return count;
    }
}