package 최대공약수와최소공배수;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int GCD(int x, int y) {
        while (y!=0) {
            int r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

    public static int LCM(int x, int y) {
        return x * y / GCD(x, y);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        bw.write(GCD(x, y)+"\n");
        bw.write(LCM(x, y)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
