package dataStructure.올바른괄호;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Main main = new Main();
        System.out.println(main.isRightBracket(str));
    }

    private String isRightBracket(String str) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (s.isEmpty() || s.peek() != '(') return "NO";
                else s.pop();
            } else {
                s.push(str.charAt(i));
            }
        }

        if (!(s.isEmpty())) return "NO";
        return "YES";
    }
}
