package string.q7_회문문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(String s) {
        String answer = "YES";

//        s = s.toLowerCase();
//        char[] chars = s.toCharArray();
//        int lt = 0, rt = chars.length - 1;
//        while (lt < rt) {
//            if(chars[lt]!=chars[rt]) return "NO";
//            lt++;
//            rt--;
//        }

        // 다른 풀이법
        String tmp = new StringBuilder(s).reverse().toString();
        if (!(tmp.equalsIgnoreCase(s))) return "NO"; // equalsIgnoreCase()는 대소문자를 무시하고 비교

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Main main = new Main();

        System.out.println(main.solution(br.readLine()));
    }
}
