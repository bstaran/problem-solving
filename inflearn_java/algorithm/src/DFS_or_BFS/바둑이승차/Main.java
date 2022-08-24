package DFS_or_BFS.바둑이승차;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int c;
    static int[] arr;
    static int answer;

    public static void dfs(int l, int sum) {

        if (sum<c) answer = Math.max(sum, answer);
        if (l==arr.length) return;

        dfs(l+1, sum+arr[l]);
        dfs(l+1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dfs(0, 0);

        System.out.println(answer);
    }
}
