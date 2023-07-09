package 균형잡힌세상_4949;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            Stack<Character> stack = new Stack<>();
            String line = br.readLine();

            if (line.equals(".")) {
                break;
            }

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == '(' || c == '[') {
                    stack.add(c);
                } else if (c == ')' || c == ']') {
                    if (stack.isEmpty()) {
                        System.out.println("no");
                        break;
                    } else if (stack.peek() == '(' && c == ')') {
                        stack.pop();
                    } else if (stack.peek() == '[' && c == ']') {
                        stack.pop();
                    } else {
                        System.out.println("no");
                        break;
                    }
                }

                if (c == '.') {
                    if (stack.isEmpty()) {
                        System.out.println("yes");
                    } else {
                        System.out.println("no");
                    }
                }
            }

        }
    }
}
