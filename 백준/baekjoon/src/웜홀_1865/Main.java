package 웜홀_1865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Edge>> graph;
    static int[] d;
    static int INF = 1000_000_000;
    static int N;

    private static BufferedReader br;


    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            initEdges();

            boolean hasNegativeCycle = bf();

            if (hasNegativeCycle) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

    }

    private static boolean bf() {
        Arrays.fill(d, INF);
        d[1] = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                for (Edge edge : graph.get(j)) {
                    if (d[edge.to] > d[j] + edge.dist) {
                        d[edge.to] = d[j] + edge.dist;
                    }
                }
            }
        }

        for (int j = 1; j <= N; j++) {
            for (Edge edge : graph.get(j)) {
                if (d[edge.to] > d[j] + edge.dist) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void initEdges() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        N = n;

        d = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m + w; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            if (i < m) {
                graph.get(start).add(new Edge(end, dist));
                graph.get(end).add(new Edge(start, dist));
            } else {
                graph.get(start).add(new Edge(end, -dist));
            }
        }
    }

    static class Edge {
        int to;
        int dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }
}
