package JadenCase문자열만들기;

import java.lang.*;

class Solution {
    public String solution(String s) {

        String[] strings = s.split(" ");
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            System.out.println(strings[i]);
            if (strings[i].length() == 0) {
                answer.append(" ");
            } else {

                StringBuilder sb = new StringBuilder(strings[i].toLowerCase());
                sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

                if (i == strings.length-1) {
                    answer.append(sb);
                } else {
                    answer.append(sb).append(" ");
                }
            }
        }
        if (s.length() != answer.length()) {
            int size = s.length() - answer.length();
            for (int i = 0; i < size; i++) {
                answer.append(" ");
            }
        }

        return answer.toString();
    }
}
