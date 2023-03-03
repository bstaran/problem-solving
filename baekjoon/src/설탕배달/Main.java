package 설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] bags = {3, 5};
        int[] dp = new int[N+1];

        for (int i = 1; i <= N; i++) {
            dp[i] = 5000;
        }

        for (int i = 0; i < bags.length; i++) {
            for (int j = bags[i]; j <= N; j++) {
                dp[j] = Math.min(dp[j], dp[j - bags[i]] + 1);
            }
        }

        if (dp[N] == 5000) {
            dp[N] = -1;
        }
        System.out.println(dp[N]);

        br.close();
    }
}
