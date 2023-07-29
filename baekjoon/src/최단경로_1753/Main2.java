package 최단경로_1753;

import java.util.*;
import java.io.*;

public class Main2 {

	static List<List<int[]>> graph = new ArrayList<>();
	static int V;
	static int E;
	static int[] d;
	static int INF = 2_000_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph.get(u).add(new int[]{v, w});
		}

		d = new int[V+1];
		Arrays.fill(d, INF);

		dijkstra(start);
		
		for (int i = 1; i <= V; i++) {
			System.out.println((d[i] == INF) ? "INF" : d[i]);
		}
	}

	static void dijkstra(int start) {
		Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.add(new int[]{start, 0});
		d[start] = 0;

		while (!pq.isEmpty()) {
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
