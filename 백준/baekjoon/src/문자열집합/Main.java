package 문자열집합;

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashSet<String> S = new HashSet<>();
        String[] length = br.readLine().split(" ");

        int N = Integer.parseInt(length[0]);
        int M = Integer.parseInt(length[1]);

        for (int i = 0; i < N; i++) {
            S.add(br.readLine());
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            if (S.contains(br.readLine())) count++;
        }
        bw.write(String.valueOf(count));
        br.close();
        bw.flush();
        bw.close();
    }
}
