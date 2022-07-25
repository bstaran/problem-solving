package dataStructure.쇠막대기;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        // (((()(()()))(())()))(()())
        // (((()(()()
        // 3 -> 7 -> 11 ->
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char p = s.charAt(i);
            if (p == ')') {
                cnt--;
                if (stack.peek() == '(') {
                    answer += cnt;
                } else {
                    answer++;
                }
            } else {
                cnt++;
            }
            stack.push(p);
        }
        System.out.println(answer);
    }
}
