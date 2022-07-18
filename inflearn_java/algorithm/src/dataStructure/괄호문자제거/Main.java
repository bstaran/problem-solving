package dataStructure.괄호문자제거;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private String solution(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                while (s.pop() != '(') continue;
            } else {
                s.push(str.charAt(i));
            }
        }
        for (int i = 0; i < s.size(); i++) sb.append(s.get(i));
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Main main = new Main();
        System.out.println(main.solution(str));
    }
}
