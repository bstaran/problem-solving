package 약수의개수와덧셈;

public class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        // 카운트할 배열 생성
        int[] count = new int[right - left + 1];

        /**
         * 나누어서 0이 되면 약수이므로 count++
         * 약수의 수에 따라 answer에 +, -
         */
        for (int i = left, countIndex = 0; i <= right; i++, countIndex++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) count[countIndex]++;
            }
            if (count[countIndex] % 2 == 0) answer += i;
            if (count[countIndex] % 2 == 1) answer -= i;
        }

//        // 제곱수를 활용한 식
//        for (int i = left; i < right; i++) {
//            if (i % Math.sqrt(i) == 0) {
//                answer -= i;
//            } else answer += i;
//        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println((solution.solution(13, 17)));
    }
}
