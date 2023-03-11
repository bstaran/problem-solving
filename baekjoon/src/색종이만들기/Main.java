package 색종이만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[][] arr;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        dfs(N, 0, 0);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void dfs(int n, int col, int row) {

        if (check(n, col, row)) {
            if (arr[row][col]==1){
                blue++;
            } else {
                white++;
            }
            return;
        }

        int half = n/2;
        dfs(half, col, row);
        dfs(half, col + half, row);
        dfs(half, col, row + half);
        dfs(half, col + half, row + half);
    }

    private static boolean check(int n, int col, int row) {
        int color = arr[row][col];

        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
