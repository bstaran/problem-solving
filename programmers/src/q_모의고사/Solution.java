package q_모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int[] answers) {
        int[][] mathAnswer = {{1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

        int[] result = {0, 0, 0};

        int n = 0;
        for (int i = 0; i < mathAnswer.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                if (n == mathAnswer[i].length) n = 0;

                if (answers[j] == mathAnswer[i][n]) result[i]++;
                n++;
            }
            n = 0;
        }

//        // 핵심 풀이 로직
//        for (int i = 0; i < answers.length; i++) {
//            if (mathAnswer[0][i%5] == answers[i]) result[0]++;
//            if (mathAnswer[1][i%8] == answers[i]) result[1]++;
//            if (mathAnswer[2][i%10] == answers[i]) result[2]++;
//        }


        List<Integer> s = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < result.length; i++) {
            if (max < result[i]) max = result[i];
        }



        if (result[0] == max) s.add(1);
        if (result[1] == max) s.add(2);
        if (result[2] == max) s.add(3);

        int[] answer = new int[s.size()];

        for (int i = 0; i < s.size(); i++) {
            answer[i] = s.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 2, 3, 4, 5})));
    }
}
