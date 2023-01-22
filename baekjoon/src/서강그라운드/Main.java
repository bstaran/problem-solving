package 서강그라운드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Queue<Integer> q = new LinkedList<>();

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int[] d = new int[n + 1];
            Arrays.fill(d, Integer.MAX_VALUE);

            pq.offer(new Node(i, 0));
            d[i] = 0;

            while (!pq.isEmpty()) {
                Node node = pq.poll();
                int now = node.index;
                int distance = node.distance;

                if (d[now] < distance) continue;

                for (int j = 0; j < graph.get(now).size(); j++) {
                    int cost = d[now] + graph.get(now).get(j).distance;
                    if (cost < d[graph.get(now).get(j).index]) {
                        d[graph.get(now).get(j).index] = cost;
                        pq.offer(new Node(graph.get(now).get(j).index, cost));
                    }
                }
            }

            q.offer(i);
            int sum = 0;
            boolean[] visited = new boolean[n + 1];
            while (!q.isEmpty()) {
                int poll = q.poll();
                if (d[poll] <= m && !visited[poll]) {
                    sum += items[poll];
                    visited[poll] = true;
                    for (int j = 0; j < graph.get(poll).size(); j++) {
                        int index = graph.get(poll).get(j).index;
                        q.offer(index);
                    }
                }
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }

    static class Node implements Comparable<Node> {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }
}
