package DP.최대점수구하기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] dy = new int[m+1];
        Arrays.fill(dy, 0);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int ps = Integer.parseInt(st.nextToken());
            int pt = Integer.parseInt(st.nextToken());
            for (int j = m; j >= pt; j--) {
                dy[j]=Math.max(dy[j-pt]+ps,dy[j]);
            }
        }

        bw.write(dy[m]+" ");
        bw.flush();
        bw.close();
    }
}
