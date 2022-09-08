package DFS_or_BFS.미로탐색DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] check;
    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void dfs(int x, int y) {

        if (x == 7 && y == 7) {
            answer++;
        } else {

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (check[nx][ny] == 0) {
                    check[nx][ny] = 1;
                    dfs(nx, ny);
                    check[nx][ny] = 0;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        check = new int[9][9];

        StringTokenizer st = null;
        for (int i = 0; i <= 8; i++) {
            if (i > 0 && i < 8) {
                st = new StringTokenizer(br.readLine());
            }

            for (int j = 0; j <= 8; j++) {
                if (i > 0 && i < 8 && j > 0 && j < 8) {
                    int n = Integer.parseInt(st.nextToken());
                    check[i][j] = n;
                }
                if (i == 0 || j == 0 || i == 8 || j == 8) {
                    check[i][j] = 1;
                }
            }
        }
        check[1][1] = 1;
        dfs(1, 1);

        System.out.println(answer);
    }
}