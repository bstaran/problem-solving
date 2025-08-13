import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    StringTokenizer st;

    int[] dp = new int[3];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int r = Integer.parseInt(st.nextToken());
      int g = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      int prevR = dp[0];
      int prevG = dp[1];
      int prevB = dp[2];

      dp[0] = Math.min(prevG, prevB) + r;
      dp[1] = Math.min(prevR, prevB) + g;
      dp[2] = Math.min(prevR, prevG) + b;
    }

    int answer = Math.min(dp[0], Math.min(dp[1], dp[2]));

    System.out.println(answer);
  }
}
