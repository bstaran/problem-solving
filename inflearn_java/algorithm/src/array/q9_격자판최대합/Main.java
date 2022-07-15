package array.q9_격자판최대합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(s[j]);
            }
        }
        int diagonalSum = 0;
        int diagonalSum2 = 0;
        int max_value = 0;
        for (int i = 0; i < n; i++) {
            int widthSum = 0;
            int heightSum = 0;
            for (int j = 0; j < n; j++) {
                widthSum += board[i][j];
                heightSum += board[j][i];
            }
            diagonalSum += board[i][i];
            diagonalSum2 += board[i][n - i - 1];

            if (max_value < widthSum) max_value = widthSum;
            if (max_value < heightSum) max_value = heightSum;
            if (max_value < diagonalSum) max_value = diagonalSum;
            if (max_value < diagonalSum2) max_value = diagonalSum2;
        }
        System.out.println(max_value);
    }
}
