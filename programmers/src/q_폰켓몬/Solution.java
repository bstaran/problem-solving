package q_폰켓몬;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        List<Integer> poketmonType = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!(poketmonType.contains(nums[i]))) poketmonType.add(nums[i]);
        }
//        System.out.println(poketmonType);

        if (poketmonType.size() > nums.length / 2) answer = nums.length / 2;
        else answer = poketmonType.size();
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 3, 3, 2, 2, 2};
        System.out.println(solution.solution(nums));
    }
}
