package 적록색약_10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int cwa;
    private static int area;
    private static int[] X = {-1, 0, 1, 0};
    private static int[] Y = {0, -1, 0, 1};
    private static int N;
    private static char[][] map;
    private static char[][] cwMap;
    private static boolean[][] visit;
    private static boolean[][] cwVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        cwMap = new char[N][N];
        visit = new boolean[N][N];
        cwVisit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                cwMap[i][j] = str.charAt(j);
            }
        }

        br.close();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    visit[i][j] = true;
                    dfs(i, j, false);
                    area++;
                }
                if (!cwVisit[i][j]) {
                    cwVisit[i][j] = true;
                    dfs(i, j, true);
                    cwa++;
                }
            }
        }
        System.out.println(area + " " + cwa);
    }

    private static void dfs(int i, int j, boolean isColorWeakness) {

        for (int k = 0; k < 4; k++) {

            int dx = j + X[k];
            int dy = i + Y[k];

            if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
                continue;
            }

            if (isColorWeakness) {
                if (cwMap[i][j] == 'R' || cwMap[i][j] == 'G') {
                    if ((cwMap[dy][dx] == 'R' || cwMap[dy][dx] == 'G') && !cwVisit[dy][dx]) {
                        cwVisit[dy][dx] = true;
                        dfs(dy, dx, true);
                    }
                } else {
                    if (cwMap[i][j] == cwMap[dy][dx] && !cwVisit[dy][dx]) {
                        cwVisit[dy][dx] = true;
                        dfs(dy, dx, true);
                    }
                }
            } else {
                if (map[i][j] == map[dy][dx] && !visit[dy][dx]) {
                    visit[dy][dx] = true;
                    dfs(dy, dx, false);
                }
            }
        }
    }
}
