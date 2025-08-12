package 테트로미노_14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int answer = Integer.MIN_VALUE;
    static int[][] mat;
    static int N;
    static int M;
    static int secondX;
    static int secondY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        mat = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i, j, 0, 0);
            }
        }

        System.out.println(answer);
    }

    public static void dfs(int y, int x, int depth, int sum) {
        if (depth == 3) {
            answer = Math.max(answer, mat[y][x] + sum);

            for (int i = 0; i < 4; i++) {
                int ny = secondY + dy[i];
                int nx = secondX + dx[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[ny][nx]) {
                    answer = Math.max(answer, sum + mat[ny][nx]);
                }
            }
            return;
        }
        if (depth == 1) {
            secondY = y;
            secondX = x;
        }

        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N && !visited[ny][nx]) {
                dfs(ny, nx, depth + 1, sum + mat[y][x]);
            }
        }
        visited[y][x] = false;
    }
}
