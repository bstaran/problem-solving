package 점프와순간이동;

import java.util.Arrays;

public class Solution {

    public int solution(int n) {
        int answer = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                answer++;
            }
            n = n / 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int answer = s.solution(6);
        System.out.println(answer);
    }
}