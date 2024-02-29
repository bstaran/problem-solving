package 쉬운최단거리_14940;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 쉬운 최단거리
 * 메모리 제한, 시간 제한/ 128MB, 1초
 * https://www.acmicpc.net/problem/14940
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] distance = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int[] arrivalLocation = new int[2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
                if (map[i][j] == 2) {
                    arrivalLocation[0] = i;
                    arrivalLocation[1] = j;
                    distance[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(arrivalLocation);

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (map[nx][ny] == 0) {
                    continue;
                }

                distance[nx][ny] = distance[x][y] + 1;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    distance[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(distance[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
