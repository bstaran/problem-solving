package DFS_or_BFS.송아지찾기;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int[] check;

    public static int bfs(int S, int E) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(S);
        check[S] = 1;
        while (!q.isEmpty()) {

            int n = q.poll();

            for (int i : new int[]{n - 1, n + 1, n + 5}) {
                if (i >= 1 && i <= 10000 && check[i] == 0) {
                    if (i == E) return check[n];
                    q.offer(i);
                    check[i] = check[n] + 1;
                }

            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int E = sc.nextInt();

        check = new int[20001];

        System.out.println(bfs(S, E));
    }
}
