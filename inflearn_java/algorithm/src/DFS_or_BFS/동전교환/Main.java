package DFS_or_BFS.동전교환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int M;
    static int N;
    static int answer;

    public static void dfs(int l, int sum) {
        if (sum > M) return;
        if (l>=answer) return;
        if (sum == M) answer= l;
        else {
            for (int i = N-1; i >= 0; i--) dfs(l+1, sum+arr[i]);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        answer=Integer.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());

        dfs(0, 0);
        System.out.println(answer);
    }
}
