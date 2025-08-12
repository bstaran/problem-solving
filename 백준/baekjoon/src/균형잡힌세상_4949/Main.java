package 균형잡힌세상_4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public String solution(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c =='(' || c =='[') stack.push(c);
            else if (c ==')') {
                if (stack.empty() || !(stack.peek()=='(')) return "no";
                else stack.pop();
            } else if (c ==']') {
                if (stack.empty() || !(stack.peek()=='[')) return "no";
                else stack.pop();
            }
        }

        if (stack.empty()) return "yes";
        return "no";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Main main = new Main();
        while (true) {
            String s = br.readLine();
            if (s.equals(".")) break;
            System.out.println(main.solution(s));
        }
    }
}
