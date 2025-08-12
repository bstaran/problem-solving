package 최대힙;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (priorityQueue.size() == 0) bw.write("0\n");
                else bw.write(String.valueOf(priorityQueue.poll())+"\n");
            } else {
                priorityQueue.offer(num);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
