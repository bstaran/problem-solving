package 인접영역_2468;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] mat;
    static boolean[][] check;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        mat = new int[n][n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                mat[i][j] = Integer.parseInt(st.nextToken());
                if (max < mat[i][j]) {
                    max = mat[i][j];
                }
            }
        }

        for (int i = 0; i <= max; i++) {
            int cnt = 0;
            check = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (mat[j][k] > i && !check[j][k]) {
                        check[j][k] = true;
                        bfs(new int[]{j, k}, i);
                        cnt++;
                    }
                }
            }
            answer = Math.max(cnt, answer);
        }

        System.out.println(answer);
    }

    private static void bfs(int[] start, int height) {
        Queue<int[]> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n || mat[nx][ny] <= height || check[nx][ny]) {
                    continue;
                }

                q.add(new int[]{nx, ny});
                check[nx][ny] = true;
            }
        }
    }
}
