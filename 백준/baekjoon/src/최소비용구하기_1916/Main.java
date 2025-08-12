package 최소비용구하기_1916;

import java.io.*;
import java.util.*;

public class Main {

	static List<List<int[]>> graph = new ArrayList<>();
	static int[] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		String[] str;
		for (int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			int st = Integer.parseInt(str[0]);
			int dtn = Integer.parseInt(str[1]);
			int cost = Integer.parseInt(str[2]);

			graph.get(st).add(new int[]{dtn, cost});
		}

		str = br.readLine().split(" ");
		int start = Integer.parseInt(str[0]);
		int destination = Integer.parseInt(str[1]);

		d = new int[N+1];

		Arrays.fill(d, 2_000_000_000);

		dijkstra(start);

		System.out.println(d[destination]);
	}

	static void dijkstra(int start) {
		Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.add(new int[]{start, 0});
		d[start] = 0;

		while (!pq.isEmpty()) {
			int[] poll = pq.poll();
			int now = poll[0];
			int dist = poll[1];

			if (d[now] < dist) continue;

			for (int i = 0; i < graph.get(now).size(); i++) {
				int[] node = graph.get(now).get(i);
				int nxt = node[0];
				int nd = node[1];
				int cost = d[now] + nd;

				if (cost < d[nxt]) {
					d[nxt] = cost;
					pq.add(new int[]{nxt, cost});
				}
			}
		}
	}
}
