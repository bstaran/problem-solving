package 지름길_1446;

import java.io.*;
import java.util.*;

public class Main {

	static List<List<int[]>> graph = new ArrayList<>();
	static int[] d;
	static int D;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		D = Integer.parseInt(str[1]);

		for (int i = 0; i <= D; i++) {
			graph.add(new ArrayList<>());
			graph.get(i).add(new int[]{i+1, 1});
		}

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int val = Integer.parseInt(input[2]);

			if (D < end) continue;
			
			graph.get(start).add(new int[]{end, val});
		}

		d = new int[D +1];
		Arrays.fill(d, 10001);

		dijkstra();

		System.out.println(d[D]);
	}

	static void dijkstra() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
		pq.add(new int[]{0, 0});
		d[0] = 0;

		while (!pq.isEmpty()) {
			int[] p = pq.poll();
			int now = p[0];
			int dist = p[1];

			if (d[now] < dist) continue;

			for (int i = 0; i < graph.get(now).size(); i++) {
				int[] node = graph.get(now).get(i);
				int nxt = node[0];
				int nd = node[1];

				if (nxt > D) continue;

				int cost = d[now] + nd;
				if (cost < d[nxt]) {
					d[nxt] = cost;
					pq.add(new int[]{nxt, cost});
				}
			}
		}
	}
}
