package 비밀지도;

import java.util.Arrays;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for (int i = 0; i < n; i++) {
            answer[i] = Integer.toBinaryString(arr1[i]|arr2[i]).replace("1", "#").replace("0", " ");
            if (answer[i].length() != n) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n-answer[i].length(); j++) {
                    sb.append("0");
                }
                answer[i] = String.valueOf(sb.append(answer[i])).replace("1", "#").replace("0", " ");
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};

        System.out.println(Arrays.toString(solution.solution(6, arr1, arr2)));
    }
}
