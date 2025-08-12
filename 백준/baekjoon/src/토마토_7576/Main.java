package 토마토_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] box;
    static Queue<Coordinate> q = new LinkedList<>();
    static int count=1;
    static int[] dotX = {0, 0, -1, 1};
    static int[] dotY = {-1, 1, 0, 0};

    public static void bfs(int row, int col) {

        while (!q.isEmpty()) {
            Coordinate coordinate = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = coordinate.x + dotX[i];
                int y = coordinate.y + dotY[i];

                if (x < 0 || y < 0 || x >= row || y >= col) continue;

                if (box[y][x] != 0) continue;

                q.offer(new Coordinate(x, y));
                count = box[coordinate.y][coordinate.x] + 1;
                box[y][x] = count;
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count-1);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        box = new int[col][row];

        for (int i = 0; i < col; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < row; j++) {
                int n = Integer.parseInt(st.nextToken());
                box[i][j] = n;
                if (n==1) q.add(new Coordinate(j, i));
            }
        }
        bfs(row, col);

    }
}
class Coordinate{
    int x;
    int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}