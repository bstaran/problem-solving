package q_3진법뒤집기;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        int num = n;
        String tmp = "";

        /**
         * 3진수로 변환하는 while문
         * 진수 변환 -> 10진수를 3으로 나눈 후 나머지를 나열하면 3진수가 된다.
         * 문제는 3진수를 거꾸로 변환하고 다시 10진수로 변환하는 것이었으므로 다음의 for문을 통해 바꿔준다.
         */
        while (num > 0) {
            tmp += String.valueOf(num % 3);
            num /= 3;
        }
        for (int i = 0; i < tmp.length(); i++) {
            answer += (int) Math.pow(3, i) * Integer.parseInt(String.valueOf(tmp.charAt(tmp.length()-i-1)));
        }
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(125);
    }
}
