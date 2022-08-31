package DFS_or_BFS.중복순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static int[] pm;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pm = new int[M];

        dfs(0);
    }

    private static void dfs(int l) {
        if (l == M) {
            for (int n : pm) System.out.print(n+" ");
            System.out.println();
        } else {
            for (int i = 1; i <= N; i++) {
                pm[l]=i;
                dfs(l+1);
            }
        }
    }
}
