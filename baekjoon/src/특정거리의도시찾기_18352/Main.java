package 특정거리의도시찾기_18352;

import java.io.*;
import java.util.*;

public class Main {

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;
	static int[] d;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		for (int i= 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
		}

		d = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);

		dijkstra(X);

		ArrayList<Integer> answer = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (d[i] == K) {
				answer.add(i);
			}
		}

		if (answer.size() == 0) {
			System.out.println(-1);
		} else {
			answer.forEach(System.out::println);
		}
	}

	static void dijkstra(int start) {

		PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[1])));
		d[start] = 0;
		visited[start] = true;
		pq.add(new int[]{start, 0});

		while (!pq.isEmpty()) {
			int[] p = pq.poll();
			int now = p[0];
			int dist = p[1];

			if (d[now] < dist) continue;

			for (int i = 0; i < graph.get(now).size(); i++) {
				int node = graph.get(now).get(i);
				int cost = d[now] + 1;

				if (!visited[node] && d[node] > cost) {
					d[node] = cost;
					pq.add(new int[]{node, cost});
				}
			}
		}
	}
}
