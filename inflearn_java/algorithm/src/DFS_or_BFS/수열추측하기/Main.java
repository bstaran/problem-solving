package DFS_or_BFS.수열추측하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, f;
    static int[] b, p, check;
    static int[][] arr = new int[35][35];
    static boolean flag = false;

    public static int combi(int n, int r) {
        if (arr[n][r] != 0) return arr[n][r];

        if (r == 0 || n == r) return 1;
        else return arr[n][r] = combi(n - 1, r - 1) + combi(n - 1, r);
    }

    public static void dfs(int L, int sum) {
        if (flag) return;
        if (L == n) {
            if (sum == f) {
                for (int n : p) System.out.print(n + " ");
                flag = true;
            }
        } else {
            for (int i = 1; i <= n; i++) {
                if (check[i] == 0) {
                    check[i] = 1;
                    p[L] = i;
                    dfs(L + 1, sum + (p[L] * b[L]));
                    check[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        f = Integer.parseInt(st.nextToken());

        b = new int[n];
        p = new int[n];
        check = new int[n + 1];

        for (int i = 0; i < n; i++) {
            b[i] = combi(n - 1, i);
        }
        dfs(0, 0);
    }
}
