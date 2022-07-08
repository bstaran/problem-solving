package 스택수열;

import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int max = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            int findValue = Integer.parseInt(br.readLine());
            while (findValue >= max) { // 찾으려는 값까지 stack에 push.
                stack.push(max++);
                sb.append("+\n");
            }
            if (stack.pop() != findValue) {
                sb.delete(0, sb.length());
                sb.append("NO");
                break;
            }
            sb.append("-\n");
        }

        System.out.println(sb);

        br.close();
    }
}
