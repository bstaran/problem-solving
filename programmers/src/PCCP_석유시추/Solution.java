package PCCP_석유시추;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    private int[] storage;
    private boolean[][] visited;
    private final int[] X = new int[]{0, 0, -1, 1};
    private final int[] Y = new int[]{1, -1, 0, 0};

    public int solution(int[][] land) {
        storage = new int[land[0].length];
        visited = new boolean[land.length][land[0].length];

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        }

        return Arrays.stream(storage).max().getAsInt();
    }

    private void bfs(int i, int j, int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        boolean[] check = new boolean[land[0].length];
        check[j] = true;
        visited[i][j] = true;

        int sum = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();

            sum++;

            for (int k = 0; k < 4; k++) {
                int dx = poll[1] + X[k];
                int dy = poll[0] + Y[k];

                if (dx < 0 || dy < 0 || dx >= land[0].length || dy >= land.length || land[dy][dx] == 0) {
                    continue;
                }

                if (!visited[dy][dx]) {
                    visited[dy][dx] = true;
                    // 누적할 열 위치 체크
                    check[dx] = true;

                    q.add(new int[]{dy, dx});
                }
            }
        }

        // 누적할 열에 오일 덩어리 값(sum) 추가
        for (int k = 0; k < check.length; k++) {
            if (check[k]) {
                storage[k] += sum;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] test1 = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };
        int answer = solution.solution(test1);
        System.out.println(answer);

        int[][] test2 = {
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}
        };
        answer = solution.solution(test2);
        System.out.println(answer);
    }
}
