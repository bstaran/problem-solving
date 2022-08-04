package 큐;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            switch (s) {
                case "pop":
                    if (q.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(q.poll() + "\n");
                    break;
                case "size":
                    bw.write(q.size() + "\n");
                    break;
                case "empty":
                    if (q.isEmpty()) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;
                case "front":
                    if (q.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(q.peek() + "\n");
                    break;
                case "back":
                    if (q.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(num + "\n");
                    break;
                default:
                    String[] push = s.split(" ");
                    q.offer(Integer.valueOf(push[1]));
                    num = Integer.parseInt(push[1]);
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
