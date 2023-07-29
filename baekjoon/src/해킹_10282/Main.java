package 해킹_10282;

import java.util.*;
import java.io.*;

public class Main {

	static List<List<int[]>> graph;
	static int INF = 2_000_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph = new ArrayList<>();
			for (int j = 0; j <= n; j++) {
				graph.add(new ArrayList<>());
			}

			int[] ds = new int[n+1];
			Arrays.fill(ds, INF);

			for (int j = 0; j < d; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());

				graph.get(b).add(new int[]{a, s});
			}

			dijkstra(c, ds);

			int count = 0, time = 0;
            for (int dist : ds) {
                if (dist != INF) {
                    count++;
					time = Math.max(dist, time);
                }
            }
			System.out.println(count + " " + time);
		}
	}

	static void dijkstra(int start, int[] d) {
		Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.add(new int[]{start, 0});
		d[start] = 0;

		while(!pq.isEmpty()) {
			int[] v = pq.poll();
			int now = v[0];
			int dist = v[1];

			if (d[now] < dist) continue;

			for (int i = 0; i < graph.get(now).size(); i++) {
				int[] nv = graph.get(now).get(i);
				int cost = d[now] + nv[1];
				if (d[nv[0]] > cost) {
					d[nv[0]] = cost;
					pq.add(new int[]{nv[0], cost});
				}
			}
		}
	}
}
