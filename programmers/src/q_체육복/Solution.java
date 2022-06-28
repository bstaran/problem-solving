package q_체육복;

import java.util.Arrays;

public class Solution {
    // 탐욕 알고리즘
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        // 순차 접근을 위한 정렬
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // 여벌의 체육복을 가진 인원이 도난당한 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i]==reserve[j]) {
                    answer++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        // 여벌의 체육복을 가진 인원이 빌려주는 경우
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    reserve[j]=-1;
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[]{2, 4}, new int[]{3}));
    }
}
