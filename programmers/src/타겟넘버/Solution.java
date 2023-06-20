package 타겟넘버;

class Solution {

    int[] numbers;
    int target;
    int answer;

    public int solution(int[] numbers, int target) {

        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);

        return answer;
    }

    private void dfs(int n, int sum) {

        if (n == numbers.length) {
            if (sum == target)
                answer++;
            return;
        }

        dfs(n+1, sum + numbers[n]);
        dfs(n+1, sum - numbers[n]);
    }
}
