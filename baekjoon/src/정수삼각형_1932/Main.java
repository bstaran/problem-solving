package 정수삼각형_1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] nums = br.readLine().split(" ");
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(nums[j]);
            }
        }
        br.close();

        dp[0][0] = triangle[0][0];
        int answer = triangle[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        System.out.println(answer);
    }
}
