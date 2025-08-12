package 스티커_9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] sticker = new int[2][N];
            for (int j = 0; j < 2; j++) {
                String[] scores = br.readLine().split(" ");
                for (int k = 0; k < N; k++) {
                    sticker[j][k] = Integer.parseInt(scores[k]);
                }
            }

            int[][] dp = new int[3][N + 1];
            dp[1][1] = sticker[0][0];
            dp[2][1] = sticker[1][0];

            for (int j = 2; j <= N; j++) {
                dp[1][j] = Math.max(dp[0][j - 1] + sticker[0][j - 1], dp[2][j - 1] + sticker[0][j - 1]);
                dp[2][j] = Math.max(dp[0][j - 1] + sticker[1][j - 1], dp[1][j - 1] + sticker[1][j - 1]);
                dp[0][j] = Math.max(dp[1][j-1], dp[2][j-1]);
            }

            System.out.println(Math.max(dp[1][N], dp[2][N]));
        }

        br.close();
    }
}
