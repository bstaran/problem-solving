package q_약수의합;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        for (int i = 1; i <= n/2; i++) {
            if (n%i==0) answer+=i;
        }
        return answer+n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(12));
    }
}
