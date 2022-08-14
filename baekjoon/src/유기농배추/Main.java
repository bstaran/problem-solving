package 유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static boolean[][] visit;
    static int[] x = {1, -1, 0, 0};
    static int[] y = {0, 0, 1, -1};

    public static void dfs(int i, int j, int m, int n) {
        visit[i][j] = true; // 조회 했는지 설정

        for (int k = 0; k < 4; k++) { // 상하좌우 배추 조회
            int cx = i + x[k];
            int cy = j + y[k];

            if (cx >= 0 && cy >= 0 && cx < m && cy < n) { // 배열 벗어남 방지
                if (!(visit[cx][cy]) && arr[cx][cy] == 1) {
                    dfs(cx, cy, m, n);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sn = Integer.parseInt(br.readLine());

        for (int i = 0; i < sn; i++) {
            int count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());


            arr = new int[M][N];
            visit = new boolean[M][N];

            for (int j = 0; j < K; j++) { // 밭에서 배추부분을 1로 바꿔주기
                st = new StringTokenizer(br.readLine());
                int nx = Integer.parseInt(st.nextToken());
                int ny = Integer.parseInt(st.nextToken());
                arr[nx][ny] = 1;
            }

            for (int j = 0; j < M; j++) {
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] == 1 && !(visit[j][k])) {
                        dfs(j, k, M, N);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }
}
