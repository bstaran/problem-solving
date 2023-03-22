package _2xn타일링2_11727;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        br.close();

        int[] dp = new int[N + 2];
        dp[1]=1;
        dp[2]=3;
        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-1] + (dp[i-2] * 2)) % 10007;
        }

        System.out.println(dp[N]);
    }
}
