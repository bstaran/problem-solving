package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();

        int length = Integer.parseInt(br.readLine());

        for (int i = 0; i < length; i++) {
            String[] command = br.readLine().split(" ");


            switch (command[0]) {
                case "push_front": {
                    dq.addFirst(Integer.parseInt(command[1]));
                    break;
                }
                case "push_back": {
                    dq.addLast(Integer.parseInt(command[1]));
                    break;
                }
                case "pop_front": {
                    if (dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.pollFirst());
                    break;
                }
                case "pop_back": {
                    if (dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.pollLast());
                    break;
                }
                case "size": {
                    System.out.println(dq.size());
                    break;
                }
                case "empty": {
                    if (dq.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                }
                case "front": {
                    if (dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.peekFirst());
                    break;
                }
                case "back": {
                    if (dq.isEmpty()) System.out.println(-1);
                    else System.out.println(dq.peekLast());
                    break;
                }
            }
        }
    }
}
