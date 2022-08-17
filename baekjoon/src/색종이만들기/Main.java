package 색종이만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int white;
    static int blue;
    public static boolean check(int col, int row, int size) {

        int color = arr[col][row];

        for (int i = col; i < col + size; i++) {
            for (int j = row; j < row + size; j++) {
                if (arr[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
    public static void paperFoldingRecursion(int col, int row, int size) {

        if (check(col, row, size)) {
            if (arr[col][row] == 0) {
                white++;
            } else {
                blue++;
            }
            return;
        }

        int half = size/2;
        paperFoldingRecursion(col, row, half);
        paperFoldingRecursion(col, row + half, half);
        paperFoldingRecursion(col + half, row, half);
        paperFoldingRecursion(col + half, row + half, half);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paperFoldingRecursion(0,0, N);

        System.out.println(white);
        System.out.println(blue);
    }
}
