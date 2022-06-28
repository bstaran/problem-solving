package q_소수찾기;

public class Solution {
    public int solution(int n) {
        int answer = n-1;

        // 시간 초과
//        for (int i = 2; i <= n; i++) {
//            for (int j = 2; j <= i; j++) {
//                if (i == j) answer++;
//                else if (i % j == 0) break;
//            }
//        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i%j==0) {
                    answer--;
                    break;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5));
    }
}
