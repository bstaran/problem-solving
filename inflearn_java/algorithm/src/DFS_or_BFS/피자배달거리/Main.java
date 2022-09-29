package DFS_or_BFS.피자배달거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Point> h, p;
    static int N, M, len, answer = Integer.MAX_VALUE;
    static int[] combination;


    public static void dfs(int L, int s) {
        if (L == M) {
            int sum = 0;
            for (Point point : h) {
                int dis = Integer.MAX_VALUE;
                for (int c : combination) {
                    dis = Math.min(dis, Math.abs(point.x - p.get(c).x) + Math.abs(point.y - p.get(c).y));
                }
                sum += dis;
            }
            answer=Math.min(sum, answer);
        } else {
            for (int i = s; i < len; i++) {
                combination[L] = i;
                dfs(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        h = new ArrayList<>();
        p = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) h.add(new Point(i, j));
                else if (num == 2) p.add(new Point(i, j));
            }
        }
        len = p.size();
        combination = new int[M];
        dfs(0, 0);
        System.out.println(answer);
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
