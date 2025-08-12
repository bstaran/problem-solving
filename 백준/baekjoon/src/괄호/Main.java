package 괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public String solution(String s) {

        Stack<String> stack = new Stack<>();
        String[] parenthesis = s.split("");
        for (int i = 0; i < parenthesis.length; i++) {
            if (parenthesis[i].equals(")")&&stack.size()==0) return "NO";

            if (parenthesis[i].equals("(")) stack.push(parenthesis[i]);
            else stack.pop();
        }
        if (stack.size()!=0) return "NO";
        return "YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Main main = new Main();
        for (int i = 0; i < n; i++) {
            System.out.println(main.solution(br.readLine()));
        }
    }
}
