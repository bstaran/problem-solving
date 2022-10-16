package 최대공약수와최소공배수;

import java.util.Arrays;

public class Solution {
    public int gcd(int n, int m) {
        while (n > 0) {
            int tmp = n;
            n = m % n;
            m = tmp;
        }
        return m;
    }
    public int lcm(int n, int m) {
        return n * m / gcd(n, m);
    }
    public int[] solution(int n, int m) {
        int[] answer = new int[2];

        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m);

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(2, 5)));
    }
}
