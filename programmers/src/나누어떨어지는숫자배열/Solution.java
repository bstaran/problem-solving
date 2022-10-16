package 나누어떨어지는숫자배열;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int[] solution(int[] arr, int divisor) {

        List<Integer> result = new ArrayList<>();

        for (int n : arr) {
            if (n % divisor == 0) {
                result.add(n);
            }
        }
        Collections.sort(result);

        if (result.isEmpty()) {
            result.add(-1);
        }

        Integer[] resultArr = result.toArray(new Integer[0]);

        int[] answer = Arrays.stream(resultArr).mapToInt(i -> i).toArray();

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {2, 36, 1, 3};
        int divisor = 1;

        int[] answer = s.solution(arr, divisor);

        System.out.println(Arrays.toString(answer));
    }

}
