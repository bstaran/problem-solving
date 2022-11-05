package 가장큰수;

import java.util.ArrayList;

public class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();

        for (int number : numbers) {
            list.add(String.valueOf(number));
        }

        list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        StringBuilder sb = new StringBuilder();

        if (list.get(0).equals("0")) return "0";

        for (String s : list) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution(new int[]{3, 30, 34, 5, 9}));
    }
}
