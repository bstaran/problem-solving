package 쿼드트리_1992;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(strings[j]);
            }
        }
        br.close();

        division(0, 0, N);
    }

    private static void division(int row, int col, int size) {

        if (check(row, col, size)) {
            System.out.print(map[col][row]);
        } else {
            System.out.print("(");

            int dividedSize = size / 2;

            division(row, col, dividedSize);
            division(row + dividedSize, col, dividedSize);
            division(row, col + dividedSize, dividedSize);
            division(row + dividedSize, col + dividedSize, dividedSize);

            System.out.print(")");
        }
    }

    private static boolean check(int row, int col, int size) {
        int num = map[col][row];

        for (int i = col; i < col + size; i++) {
            for (int j = row; j < row + size; j++) {
                if (map[i][j] != num) {
                    return false;
                }
            }
        }
        return true;
    }
}
