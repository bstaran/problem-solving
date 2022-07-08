package 요세푸스문제0;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");
        while (!(queue.isEmpty())) {
            for (int i = 1; i < m; i++) {
                queue.offer(queue.poll());
            }
            result.append(queue.poll());
            if (queue.size() != 0) result.append(", ");
        }
        result.append(">");
        System.out.println(result);
    }
}