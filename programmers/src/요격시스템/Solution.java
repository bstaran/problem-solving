package 요격시스템;
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;

        Arrays.sort(targets, (m1, m2) -> {
            if (m1[1] == m2[1]) {
                return m1[0] - m2[0];
            }
            return m1[1] - m2[1];
        });
        System.out.println(Arrays.deepToString(targets));

        int[] target = targets[0];
        for (int i = 1; i < targets.length; i++) {
            if (target[1] <= targets[i][0]) {
                answer++;
                target = targets[i];
            }
        }

        return answer;
    }
}