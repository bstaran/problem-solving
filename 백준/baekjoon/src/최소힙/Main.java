package 최소힙;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue queue = new PriorityQueue();
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n==0 && queue.isEmpty()) bw.write("0\n");
            else if (n==0) bw.write(queue.poll()+"\n");
            else queue.offer(n);
        }

        bw.flush();
        bw.close();
    }
}
