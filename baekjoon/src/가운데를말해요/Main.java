package 가운데를말해요;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> beforeQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> afterQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (beforeQ.size() == afterQ.size()) beforeQ.offer(input);
            else {
                if (beforeQ.peek() > input) {
                    afterQ.offer(beforeQ.poll());
                    beforeQ.offer(input);
                } else afterQ.offer(input);
            }

            bw.write(String.valueOf(beforeQ.peek()));
            if (i!=n-1) bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
