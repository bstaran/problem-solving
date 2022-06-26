package q_문자열내마음대로정렬하기;

import java.util.ArrayList;

public class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];


        ArrayList<String> stringList = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            stringList.add(strings[i].charAt(n) + strings[i]);
        }

        stringList.sort(String.CASE_INSENSITIVE_ORDER);

        for (int i = 0; i < stringList.size(); i++) {
            answer[i] = stringList.get(i).substring(1);
        }
//        System.out.println(Arrays.toString(answer));
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"abce", "abcd", "cdx"}, 1);
    }
}
