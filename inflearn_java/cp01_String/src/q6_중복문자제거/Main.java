package q6_중복문자제거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public String solution(String s) {
        String answer = "";
//        char[] chars = s.toCharArray();
//
//        for (char c : chars) {
//            if (!(answer.contains(String.valueOf(c)))) answer += c;
//        }

        // 강사님 코드
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == i) answer += s.charAt(i);
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Main main = new Main();

        System.out.println(main.solution(br.readLine()));
    }
}
