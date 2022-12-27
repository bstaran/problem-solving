package 피보나치함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] fibo = new int[41][2];
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 2; j <= n; j++) {
                fibo[j][0] = fibo[j - 2][0] + fibo[j - 1][0];
                fibo[j][1] = fibo[j - 2][1] + fibo[j - 1][1];
            }
            System.out.println(fibo[n][0] + " " + fibo[n][1]);
        }
    }
}