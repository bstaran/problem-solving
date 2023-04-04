package 단지번호붙이기_2667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    private static int[][] map;
    private static int[] X = {-1, 0, 1, 0};
    private static int[] Y = {0, -1, 0, 1};
    private static int N;
    private static int house = 1;
    private static int cnt;
    private static ArrayList<Integer> houseCnt = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] strings = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(strings[j]);
            }
        }

        br.close();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    house++;
                    cnt = 1;
                    map[i][j] = house;
                    dfs(i, j);
                    houseCnt.add(cnt);
                }
            }
        }

        System.out.println(house-1);
        Collections.sort(houseCnt);
        for (Integer num : houseCnt) {
            System.out.println(num);
        }
    }

    private static void dfs(int i, int j) {

        for (int k = 0; k < 4; k++) {
            int dx = j + X[k];
            int dy = i + Y[k];

            if (dx < 0 || dx >= N || dy < 0 || dy >= N) {
                continue;
            }

            if (map[dy][dx] == 1) {
                map[dy][dx] = house;
                cnt++;
                dfs(dy, dx);
            }
        }
    }
}
