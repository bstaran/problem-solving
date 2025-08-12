package 웰컴키트_30802;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String[] shirts = br.readLine().split(" ");
        String[] tp = br.readLine().split(" ");
        int T = Integer.parseInt(tp[0]);
        int P = Integer.parseInt(tp[1]);

        int TOrder = 0;
        for (int i = 0; i < 6; i++) {
            int n = Integer.parseInt(shirts[i]);
            TOrder += n / T + (n % T != 0 ? 1 : 0);
        }

        bw.write(String.valueOf(TOrder));
        bw.newLine();
        bw.write(N / P + " " + N % P);
        bw.flush();
    }
}
