import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] cost = new int[N][3];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      cost[i][0] = Integer.parseInt(st.nextToken());
      cost[i][1] = Integer.parseInt(st.nextToken());
      cost[i][2] = Integer.parseInt(st.nextToken());
    }

    int[] dp = new int[3];
    dp[0] = cost[0][0];
    dp[1] = cost[0][1];
    dp[2] = cost[0][2];
    for (int i = 1; i < cost.length; i++) {
      int[] temp = new int[3];
      temp[0] = Math.min(dp[1], dp[2]) + cost[i][0];
      temp[1] = Math.min(dp[0], dp[2]) + cost[i][1];
      temp[2] = Math.min(dp[0], dp[1]) + cost[i][2];
      dp = temp;
    }

    int answer = Math.min(dp[0], dp[1]);
    answer = Math.min(answer, dp[2]);

    System.out.println(answer);
  }
}
