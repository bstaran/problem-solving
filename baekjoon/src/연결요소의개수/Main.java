package 연결요소의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        check = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            map[p1][p2] = 1;
            map[p2][p1] = 1;
        }
        int count = 0;
        for (int i = 1; i <=N ; i++) {
            if (!check[i]) {
                dfs(i, N);
                count++;
            }
        }

        System.out.println(count);
    }

    public static void dfs(int from, int n) {
        check[from] = true;

        for (int i = 1; i <= n; i++) {
            if (map[from][i] == 1 && !check[i]) {
                dfs(i, n);
            }
        }
    }
}
