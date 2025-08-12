package ACM호텔;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int floor = N % H;
            int number = N / H + 1;

            int answer = 0;
            if (floor == 0) {
                floor=H;
                answer = floor * 100 + number - 1;
            } else {
                answer = floor * 100 + number;
            }

            bw.write(answer+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
