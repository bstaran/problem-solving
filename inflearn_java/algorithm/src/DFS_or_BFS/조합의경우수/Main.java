package DFS_or_BFS.조합의경우수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int r;
    static int[][] arr;

    public static int dfs(int n, int r) {
        if (arr[n][r]!=0) return arr[n][r];

        if (r==0 || n==r) return 1;
        else return arr[n][r] = dfs(n-1, r-1) + dfs(n-1, r);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        arr = new int[n+1][r+1];
        System.out.println(dfs(n, r));
    }
}
