package 종이의개수_1780;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[][] graph;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }
        br.close();

        answer = new int[3];
        solve(0, 0, N);

        for (int num : answer) {
            System.out.println(num);
        }
    }

    private static void solve(int x, int y, int size) {
        if (check(x, y, size)) {
            // -1, 0, 1 순으로 출력해야 하기 때문에 +1
            answer[graph[y][x] + 1]++;
        } else {
            // 9등분
            int newSize = size / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    // 좌료의 시작점을 계산해서 재귀
                    solve(x + newSize * j, y + newSize * i, newSize);
                }
            }
        }

    }

    private static boolean check(int x, int y, int size) {

        int start = graph[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                // 시작점과 다른 숫자가 있으면 false
                if (start != graph[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
