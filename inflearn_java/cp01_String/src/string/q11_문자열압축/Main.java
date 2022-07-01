package string.q11_문자열압축;


import java.util.Scanner;

public class Main {
    public String solution(String s) {
        s = s + " ";
        String answer = "";
        int count = 1;
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) count ++;
            else {
                answer += s.charAt(i);
                if (count>1) answer+=count;
                count=1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(main.solution(s));
    }
}
