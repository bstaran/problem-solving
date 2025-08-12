package 타임머신_11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final long INF = 30_000_000_000L;
    static Edge[] edges;
    static long[] d;
    static int N;
    static int M;

    public static void initEdges() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, c);
        }
    }

    public static void main(String[] args) throws IOException {
        initEdges();
        boolean hasNegativeCycle = bf();

        if (hasNegativeCycle) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                System.out.println((d[i] != INF) ? d[i] : -1);
            }
        }
    }

    private static boolean bf() {
        d = new long[N + 1];
        Arrays.fill(d, INF);
        d[1] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int from = edges[j].from;
                int to = edges[j].to;
                long dist = edges[j].dist;

                if (d[from] != INF && d[to] > d[from] + dist) {
                    d[to] = d[from] + dist;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            int from = edges[i].from;
            int to = edges[i].to;
            long dist = edges[i].dist;

            if (d[from] != INF && d[to] > d[from] + dist) {
                return true;
            }
        }

        return false;
    }

    public static class Edge {

        int from;
        int to;
        long dist;

        public Edge(int from, int to, long dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }
}
