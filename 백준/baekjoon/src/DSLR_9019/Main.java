package DSLR_9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Queue<DSLR> queue;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bfs(A, B);
        }
    }

    private static void bfs(int a, int b) {
        queue = new LinkedList<>();
        visited = new boolean[10000];
        queue.add(new DSLR(a, ""));

        visited[a] = true;
        while (!queue.isEmpty()) {
            DSLR e = queue.poll();

            if (e.a == b) {
                System.out.println(e.ops);
                break;
            }

            int d = (e.a * 2) % 10000;
            if (!visited[d]) {
                visited[d] = true;
                queue.add(new DSLR(d, e.ops + "D"));
            }

            int s = 0;
            if (e.a == 0) {
                s = 9999;
            } else {
                s = e.a - 1;
            }
            if (!visited[s]) {
                visited[s] = true;
                queue.add(new DSLR(s, e.ops + "S"));
            }

            int l = (e.a % 1000) * 10 + e.a / 1000;
            if (!visited[l]) {
                visited[l] = true;
                queue.add(new DSLR(l, e.ops + "L"));
            }

            int r = ((e.a % 10) * 1000) + e.a / 10;
            if (!visited[r]) {
                visited[r] = true;
                queue.add(new DSLR(r, e.ops + "R"));
            }
        }
    }
}


class DSLR {
    int a;
    String ops;

    public DSLR(int a, String ops) {
        this.a = a;
        this.ops = ops;
    }
}
