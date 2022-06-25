package q_두개뽑아서더하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> answerList = new ArrayList<>();
        // Set<Integer> set = new HashSet<>(); -> Set의 특징을 이용해서 중복을 제거해도 됨.

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                //            if (i > numbers.length - 1) break; // 인덱스 예외 방지
                int val = numbers[i] + numbers[j];
                if (!(answerList.contains(val))) answerList.add(val); // 중복된 값 체크
            }

        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(new int[]{5,0,2,7})));
    }

}
