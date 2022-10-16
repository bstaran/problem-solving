package _2016;

public class Solution {

    public String solution(int a, int b) {
        String answer = "";

        int date = 0;

        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        for (int i = 0; i < a - 1; i++) {
            date += month[i];
        }
        date += b - 1;
        answer = day[date % 7];

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.solution(5, 24));
    }
}
