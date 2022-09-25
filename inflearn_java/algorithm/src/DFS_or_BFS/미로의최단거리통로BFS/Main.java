package DFS_or_BFS.미로의최단거리통로BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] table;
    static int[][] check;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int bfs(int x, int y) {


        Queue<Integer[]> queue = new LinkedList<>();
        queue.offer(new Integer[]{x, y});

        check[y][x] = 1;
        table[y][x] = 1;
        while (!queue.isEmpty()) {
            Integer[] n = queue.poll();

            x = n[0];
            y = n[1];

            if (x == 7 && y == 7) return table[y][x]-1;

            for (int i = 0; i < 4; i++) {
                int nx = n[0] + dx[i];
                int ny = n[1] + dy[i];
                if (check[ny][nx] == 0) {
                    queue.offer(new Integer[]{nx, ny});
                    table[ny][nx] = table[y][x] + 1;
                    check[y][x]=1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        table = new int[9][9];
        check = new int[9][9];

        StringTokenizer st = null;
        for (int i = 0; i < 9; i++) {
            if (i != 0 && i != 8) {
                st = new StringTokenizer(br.readLine());
            }

            for (int j = 0; j < 9; j++) {
                if (i == 0 || j == 0 || i == 8 || j == 8) {
                    table[i][j] = 1;
                    check[i][j] = 1;
                } else {
                    int n = Integer.parseInt(st.nextToken());
                    table[i][j] = n;
                    check[i][j] = n;
                }
            }
        }

        System.out.println(bfs(1, 1));
    }
}
