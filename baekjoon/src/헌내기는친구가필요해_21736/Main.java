package 헌내기는친구가필요해_21736;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/21736
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int[] iLocation = new int[2];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'I') {
                    iLocation[0] = i;
                    iLocation[1] = j;
                }
            }
        }

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(iLocation);
        visited[iLocation[0]][iLocation[1]] = true;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] location = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + location[1];
                int ny = dy[i] + location[0];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                    continue;
                }

                if (visited[ny][nx]) {
                    continue;
                }

                if (map[ny][nx] == 'X') {
                    continue;
                }

                if (map[ny][nx] == 'P') {
                    answer++;
                }

                visited[ny][nx] = true;
                queue.add(new int[] {ny, nx});
            }
        }

        if (answer == 0) {
            bw.write("TT");
        } else {
            bw.write(String.valueOf(answer));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
