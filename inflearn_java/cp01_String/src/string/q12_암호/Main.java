package string.q12_암호;

import java.util.Scanner;

public class Main {
    public String solution(int n, String s) {
        s = s.replace("#", "1").replace("*", "0");

        String answer = "";
        for (int i = 0; i < n; i++) {
            char c = (char) Integer.parseInt(s.substring(0, 7), 2);
            s = s.substring(7);

            answer += c;
        }
        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        String s = sc.next();
        System.out.println(main.solution(n, s));
    }
}
