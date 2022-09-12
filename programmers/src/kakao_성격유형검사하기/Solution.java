package kakao_성격유형검사하기;

import java.util.HashMap;

public class Solution {
    public String solution(String[] survey, int[] choices) {

        char[][] list = {{'R', 'T'}, {'C', 'F'}, {'J', 'M'}, {'A','N'}};
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};

        HashMap<Character, Integer> voteResult = new HashMap<>();

        for (char[] chars : list) {
            voteResult.put(chars[0], 0);
            voteResult.put(chars[1], 0);
        }

        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4)
                voteResult.put(survey[i].charAt(0), voteResult.get(survey[i].charAt(0)) + score[choices[i]]);
            else voteResult.put(survey[i].charAt(1), voteResult.get(survey[i].charAt(1)) + score[choices[i]]);
        }

        char[] answer = new char[4];

        for (int i = 0; i < 4; i++) {
            if (voteResult.get(list[i][0]) >= voteResult.get(list[i][1])) answer[i] = list[i][0];
            else answer[i] = list[i][1];
        }

        return String.valueOf(answer);
    }

    public static void main(String[] args) {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};

        Solution solution = new Solution();
        System.out.println(solution.solution(survey, choices));
    }
}
