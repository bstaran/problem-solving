package 체육복;

public class Solution {
    // 탐욕 알고리즘
    public int solution(int n, int[] lost, int[] reserve) {
//        int answer = n - lost.length;
        int answer = 0;

        boolean[] lostCheck = new boolean[n];
        boolean[] reserveCheck = new boolean[n];

        for (int i = 0; i < lost.length; i++) {
            lostCheck[lost[i] - 1] = true;
        }

        for (int i = 0; i < reserve.length; i++) {
            int student = reserve[i] - 1;
            if (lostCheck[student]) lostCheck[student] = false;
            else reserveCheck[student] = true;
        }

        answer = n;
        for (int i = 0; i < n; i++) {
            if (lostCheck[i]) {
                if (i > 0 && reserveCheck[i - 1]) reserveCheck[i - 1] = false;
                else if (i < n - 1 && reserveCheck[i + 1]) reserveCheck[i + 1] = false;
                else answer--;
            }
        }

//        // 여벌의 체육복을 가진 인원이 도난당한 경우
//        for (int i = 0; i < lost.length; i++) {
//            for (int j = 0; j < reserve.length; j++) {
//                if (lost[i] == reserve[j]) {
//                    answer++;
//                    lost[i] = -1;
//                    reserve[j] = -1;
//                    break;
//                }
//            }
//        }
//
//        // 여벌의 체육복을 가진 인원이 빌려주는 경우
//        for (int i = 0; i < lost.length; i++) {
//            for (int j = 0; j < reserve.length; j++) {
//                if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
//                    reserve[j] = -1;
//                    answer++;
//                    break;
//                }
//            }
//        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5, new int[]{2, 4}, new int[]{1, 2, 4, 5}));
    }
}
