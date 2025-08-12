package 미로탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    private static final int[] x = {-1, 0, 1, 0};
    private static final int[] y = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(split[j]);
            }
        }

        System.out.println(bfs(N, M));

        br.close();
    }

    private static int bfs(int n, int m) {

        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[] {0, 0});

        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            if (poll[0] == n && poll[1] == m) {
                break;
            }

            for (int i = 0; i < 4; i++) {
                int dx = poll[1] + x[i];
                int dy = poll[0] + y[i];
                if (dx < 0 || dx >= m || dy < 0 || dy >= n) {
                    continue;
                }
                if (arr[dy][dx] == 1) {
                    q.offer(new Integer[]{dy, dx});
                    arr[dy][dx] = arr[poll[0]][poll[1]] + 1;
                }
            }
        }

        return arr[n-1][m-1];
    }
}
