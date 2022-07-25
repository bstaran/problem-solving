package dataStructure.postfix;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Integer> stack = new Stack<>();

        int answer = 0;
        for (int i = 0; i < s.length(); i++) {

            if (Character.isDigit(s.charAt(i))) {
                stack.push(Character.getNumericValue(s.charAt(i)));
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (s.charAt(i)=='+') stack.push(lt+rt);
                else if(s.charAt(i)=='-') stack.push(lt-rt);
                else if(s.charAt(i)=='*') stack.push(lt*rt);
                else if(s.charAt(i)=='/') stack.push(lt/rt);
            }
        }
        answer = stack.pop();
        System.out.println(answer);
    }
}
