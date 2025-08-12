package 프린터큐;

import java.io.*;
import java.util.*;

public class Main {
    public int solution(Queue<Integer> q, Queue<Integer> pq, int m) {

        int cnt = 0;
        while (true) {
            if (q.peek() == pq.peek()) {
                if (m == 0) {
                    cnt++;
                    break;
                }
                q.poll();
                pq.poll();
                cnt++;
            } else q.offer(q.poll());
            if (m == 0) m = q.size();
            m--;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int doc = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<Integer> q = new LinkedList<>();
            Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            st = new StringTokenizer(br.readLine());
            Main main = new Main();
            for (int j = 0; j < doc; j++) {
                int num = Integer.parseInt(st.nextToken());
                q.offer(num);
                pq.offer(num);
            }
            bw.write(main.solution(q, pq, m) + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
