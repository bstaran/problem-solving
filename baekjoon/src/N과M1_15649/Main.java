package N과M1_15649;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static boolean[] visit;
    private static int[] nums;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N + 1];
        nums = new int[M + 1];

        dfs(1);

        bw.flush();
        bw.close();
    }

    private static void dfs(int l) throws IOException {

        if (l > M) {
            for (int i = 1; i <= M; i++) {
                bw.append(String.valueOf(nums[i])).append(" ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                nums[l] = i;
                dfs(l+1);
                visit[i] = false;
            }
        }
    }
}
