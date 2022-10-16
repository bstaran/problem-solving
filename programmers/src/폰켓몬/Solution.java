package 폰켓몬;


import java.util.HashSet;


public class Solution {
    public int solution(int[] nums) {

        HashSet<Integer> poketmonType = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            poketmonType.add(nums[i]);
        }

        return Math.min(poketmonType.size(), nums.length / 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 3, 3, 2, 2, 2};
        System.out.println(solution.solution(nums));
    }
}
