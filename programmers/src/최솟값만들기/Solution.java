package 최솟값만들기;

import java.util.Arrays;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            int result = A[i] * B[B.length - i - 1];
            answer += result;
        }

        return answer;
    }
}