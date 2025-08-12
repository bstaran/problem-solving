package 토마토_7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][][] arr;
    private static Queue<xyz> q = new LinkedList<>();
    private static int[] x = {0, 0, -1, 1, 0, 0};
    private static int[] y = {0, 0, 0, 0, -1, 1};
    private static int[] z = {1, -1, 0, 0, 0, 0};
    private static int m;
    private static int n;
    private static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][n][m];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int tomatoState = Integer.parseInt(st.nextToken());
                    if (tomatoState==1) {
                        q.offer(new xyz(k, j, i));
                    }
                    arr[i][j][k] = tomatoState;
                }
            }
        }

        bfs();

        int days = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    if (days < arr[i][j][k]) {
                        days = arr[i][j][k];
                    }
                }
            }
        }

        if (days == 1) {
            System.out.println(0);
        } else {
            System.out.println(days - 1);
        }

        br.close();
    }

    private static void bfs() {

        while (!q.isEmpty()) {
            xyz poll = q.poll();

            for (int i = 0; i < 6; i++) {
                int dx = poll.x + x[i];
                int dy = poll.y + y[i];
                int dz = poll.z + z[i];

                if (dx < 0 || dx >= m || dy < 0 || dy >= n || dz < 0 || dz >= h || arr[dz][dy][dx] == -1) {
                    continue;
                }

                if (arr[dz][dy][dx] == 0) {
                    arr[dz][dy][dx] = arr[poll.z][poll.y][poll.x] + 1;
                    q.offer(new xyz(dx, dy, dz));
                }
            }
        }
    }

    static class xyz {
        int x;
        int y;
        int z;

        public xyz(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
