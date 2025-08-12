package N_Queen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    private static int[] mat;
    private static int N;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        mat = new int[N];

        dfs(0);

        System.out.println(answer);
    }

    private static void dfs(int l) {
        if (l == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            mat[l] = i;

            if (isQueenable(l)) {
                dfs(l + 1);
            }
        }
    }

    private static boolean isQueenable(int l) {
        for (int j = 0; j < l; j++) {
            // 같은 행에 존재하는지 검사
            // 대각선에 존재하는지 검사
            //  1. 두 퀸의 열과 행 거리가 같다면 대각선에 포함
            //  2. l-j -> 열 거리, mat[l] - mat[j] -> 행 거리
            if (mat[j] == mat[l] || Math.abs(l - j) == Math.abs(mat[l] - mat[j])) {
                return false;
            }
        }
        return true;
    }
}
