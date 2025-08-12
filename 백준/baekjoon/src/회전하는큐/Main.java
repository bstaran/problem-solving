package 회전하는큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);

        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) deque.add(i);

        String[] values = br.readLine().split(" ");

        int count = 0;
        for (int i = 0; i < M; i++) {
            int value = Integer.parseInt(values[i]);
            int index = deque.indexOf(value);
            int length = deque.size();
            if (index > length / 2) {
                for (int j = 0; j < length - index; j++) {
                    int m = deque.pollLast();
                    deque.offerFirst(m);
                    count++;
                }
            } else {
                for (int j = 0; j < index; j++) {
                    int m = deque.pollFirst();
                    deque.offerLast(m);
                    count++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(count);
    }
}
