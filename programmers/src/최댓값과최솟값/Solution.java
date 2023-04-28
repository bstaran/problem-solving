package 최댓값과최솟값;

class Solution {
    public String solution(String s) {

        String[] stringNums = s.split(" ");

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < stringNums.length; i++) {
            int num = Integer.parseInt(stringNums[i]);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return min + " " + max;
    }
}
