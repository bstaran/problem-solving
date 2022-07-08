package 절댓값큐;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> Q = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);
            if (abs1 == abs2) return o1 < o2 ? -1 : 1; // o1 == o2, return 0;
            return abs1 - abs2;

            // if (o1 > o2)  return -1 조건 == 내가 원하는 순서
            // else return 1
        });
        // stable한 정렬, stable하지 않은 정렬
        // 1, 2-1, 4, 2-2
        // 1, 2-1, 2-2, 4
        // 1, 2-2, 2-1, 4

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) Q.offer(num);
            else if (Q.isEmpty()) bw.write(0 + "\n");
            else bw.write(Q.poll()+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
