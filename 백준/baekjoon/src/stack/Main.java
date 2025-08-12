package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    final List<Integer> stack = new ArrayList<>();

    public void push(int n) {
        stack.add(n);
    }
    public int pop() {
        if (stack.size()==0) return -1;
        int n = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return n;
    }

    public int size() {
        return stack.size();
    }

    public int empty() {
        if (stack.size()==0) return 1;
        return 0;
    }

    public int top() {
        if (empty()==1) return -1;
        return stack.get(stack.size()-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Main main1 = new Main();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.contains("push")) {
                String[] cm = s.split(" ");
                main1.push(Integer.parseInt(cm[1]));
            } else if (s.equals("top")) {
                System.out.println(main1.top());;
            } else if (s.equals("pop")) {
                System.out.println(main1.pop());;
            } else if (s.equals("size")) {
                System.out.println(main1.size());;
            } else if (s.equals("empty")) {
                System.out.println(main1.empty());;
            }

        }
    }
}
