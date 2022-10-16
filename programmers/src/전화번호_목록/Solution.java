package 전화번호_목록;

import java.util.HashMap;

public class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++)
            map.put(phone_book[i], 0);

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) return false;
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
