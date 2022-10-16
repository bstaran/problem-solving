package 전화번호_목록;

import java.util.HashMap;

public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();

        for (String s : phone_book) map.put(s, 0);

        for (String s : phone_book) {
            for (int j = 0; j < s.length(); j++) {
                if (map.containsKey(s.substring(0, j))) return false;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution s = new Solution();

        String[] phoneBook = {"119", "97674223", "1195524421"};

        System.out.println(s.solution(phoneBook));
    }
}
