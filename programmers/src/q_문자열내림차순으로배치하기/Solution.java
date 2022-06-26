package q_문자열내림차순으로배치하기;

import java.util.Arrays;

public class Solution {
    public String solution(String s) {
        String answer = "";
        char[] chars = s.toCharArray();

        Arrays.sort(chars);

        StringBuilder stringBuilder = new StringBuilder(new String(chars));

        answer = stringBuilder.reverse().toString();

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("Zbcdefg");
    }
}
