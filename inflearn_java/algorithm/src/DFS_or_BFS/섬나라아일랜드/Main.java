package DFS_or_BFS.섬나라아일랜드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static boolean[][] check;
    static int[] nx={0, 0, 1, -1, -1, 1, 1, -1};
    static int[] ny={1, -1, 0, 0, -1, 1, -1, 1};
    static int answer;

    public static void dfs() {

        Stack<Integer[]> stack = new Stack<>();

        int length = map.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (map[i][j]==1 && !check[i][j]){

                    stack.push(new Integer[]{j, i});
                    while(!stack.isEmpty()) {

                        Integer[] pop = stack.pop();
                        int x = pop[0];
                        int y = pop[1];
                        check[y][x] = true;
                        for (int k = 0; k < 8; k++) {
                            int dx = x + nx[k];
                            int dy = y + ny[k];
                            if (dx >= 0 && dx < length && dy >= 0 && dy < length && !check[dy][dx] && map[dy][dx]==1) {
                                stack.push(new Integer[]{dx, dy});
                            }
                        }
                    }
                    answer++;
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        check = new boolean[n][n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <n; j++) {
                int e = Integer.parseInt(st.nextToken());
                map[i][j]=e;
            }
        }

        dfs();
        System.out.println(answer);
    }
}
