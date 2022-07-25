package 팰린드롬수;

import java.io.*;
import java.util.Stack;

public class Main {
    public String solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.length() % 2 == 0) {
                if (s.length() / 2 > i) {
                    stack.push(s.charAt(i));
                } else {
                    if (stack.pop() != s.charAt(i)) return "no";
                }
            } else {
                if (s.length() / 2 > i) {
                    stack.push(s.charAt(i));
                } else {
                    if (s.length() / 2 == i) continue;
                    if (stack.pop() != s.charAt(i)) return "no";
                }
            }
        }
        return "yes";
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Main main = new Main();

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;

            bw.write(main.solution(s) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
