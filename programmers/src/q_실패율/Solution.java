package q_실패율;

import java.util.Arrays;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        float[] result = new float[N];


        int num = stages.length;
        for (int i = 1; i <= answer.length; i++) {
            int fail = 0;
            for (int j = 0; j < stages.length; j++) {
                if (stages[j] == -1) continue;
                if (stages[j] <= i) {
                    fail++;
                    stages[j] = -1;
                }
            }
            float failureRate;
            // 스테이지에 도달한 유저가 없다면 실패율 0
            if (fail == 0) failureRate = 0;
            else {
                failureRate = (float) fail / num;
                num -= fail;
            }
            result[i - 1] = failureRate;
        }
//        System.out.println(Arrays.toString(result));

        // result 값을 내림차순으로 answer에 넣어주기
        // 스테이지 실패율이 같다면 작은 번호 스테이지가 먼저
        for (int i = 0; i < result.length; i++) {
            float max = 0;
            for (int j = 0; j < result.length; j++) {
                if (result[j] > max) {
                    max = result[j];
                }
            }
            for (int j = 0; j < result.length; j++) {
                if (result[j] == max) {
                    answer[i] = j + 1;
                    result[j] = -1;
                    break;
                }
            }
        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stages = {4, 4, 4, 4, 4};
        int N = 4;
        solution.solution(N, stages);
    }
}
