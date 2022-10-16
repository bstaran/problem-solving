package 수박수박수박수박수박;

public class Solution {

    public String solution(int n) {
        int repeat = n/2;

        String answer = "";
        if (n % 2 == 0) {
            for (int i = 0; i < repeat; i++) {
                answer += "수박";
            }
        } else {
            for (int i = 0; i < repeat; i++) {
                answer += "수박";
            }
            answer += "수";
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(4));
    }
}
