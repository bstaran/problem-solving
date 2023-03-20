package 합승택시요금;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {

    static ArrayList<ArrayList<Node>> graph;
    static int N;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        graph = new ArrayList<>();
        N = n;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < fares.length; i++) {
            int start = fares[i][0];
            int to = fares[i][1];
            int cost = fares[i][2];

            graph.get(start).add(new Node(to, cost));
            graph.get(to).add(new Node(start, cost));
        }

        int[] S = dijkstra(s);
        int[] A = dijkstra(a);
        int[] B = dijkstra(b);


        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, S[i] + A[i] + B[i]);
            System.out.println(S[i] + A[i] + B[i]);
        }
        System.out.println("answer : " + answer);
        return answer;
    }

    public static int[] dijkstra(int start) {

        int[] d = new int[N+1];
        Arrays.fill(d, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.offer(new Node(start, 0));
        d[start] = 0;

        while (!pq.isEmpty()) {

            Node poll = pq.poll();
            int now = poll.to;
            int dist = poll.cost;

            if (d[now] < dist) continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                Node node = graph.get(now).get(i);
                int cost = d[now] + node.cost;
                if (d[node.to] > cost) {
                    d[node.to] = cost;
                    pq.offer(new Node(node.to, cost));
                }
            }

        }

        return d;

    }

    static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}