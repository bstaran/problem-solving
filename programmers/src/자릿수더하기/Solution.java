package 자릿수더하기;

public class Solution {

    public int solution(int n) {

        int num = n;

        int answer = 0;

        while (num > 0) {
            answer += num%10;
            num = num/10;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int result = solution.solution(12345);

        System.out.println(result);
    }
}
