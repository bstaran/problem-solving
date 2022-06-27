package q_K번째수;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

//        for (int i = 0; i < commands.length; i++) {
//            int[] arr = new int[commands[i][1] - commands[i][0] + 1];
//            for (int j = commands[i][0] - 1, arrayIndex = 0; j < commands[i][1]; j++, arrayIndex++) {
//                arr[arrayIndex] = array[j];
//            }
//            Arrays.sort(arr);
//            answer[i] = arr[commands[i][2] - 1];
//        }

        // copyOfRange()를 사용한 풀이
        for (int i = 0; i < commands.length; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(arr);
            answer[i] = arr[commands[i][2] - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}
