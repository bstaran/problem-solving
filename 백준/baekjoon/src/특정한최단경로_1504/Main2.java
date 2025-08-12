package 특정한최단경로_1504;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

    static List<List<int[]>> graph = new ArrayList<>();
    static int N;
    static int M;
    static int INF = 200_000_000;
    static int[] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        d = new int[N+1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new int[]{b, c});
            graph.get(b).add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int result1 = 0, result2 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, N);

        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, N);

        if (result1 >= INF && result2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(result1, result2));
        }
    }

    static int dijkstra(int start, int end) {
        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        Arrays.fill(d, INF);

        q.add(new int[]{start, 0});
        d[start] = 0;

        while (!q.isEmpty()) {
            int[] v = q.poll();
            int now = v[0];
            int dist = v[1];

            if (d[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int[] nv = graph.get(now).get(i);
                int cost = d[now] + nv[1];
                if (d[nv[0]] > cost) {
                    d[nv[0]] = cost;
                    q.add(new int[]{nv[0], cost});
                }
            }
        }
        return d[end];
    }
}
