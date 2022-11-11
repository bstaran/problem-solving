package 카펫;

import java.util.Arrays;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        int totalSize = brown + yellow;

        for (int i = 3; i < totalSize; i++) {

            int num = totalSize / i;

            if (totalSize % num == 0 && num >= 3) {

                int row = i-2;
                int col = num-2;

                if (row*col==yellow) {
                    answer[0] = i;
                    answer[1] = num;
                }
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.solution(10, 2)));
    }
}
