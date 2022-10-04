package greedy.다익스트라알고리즘;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    /**
     * 6 9
     * 1 2 12 // 1번 정점에서 2번정점으로 가는데 12의 비용이 든다.
     * 1 3 4
     * 2 1 2
     * 2 3 5
     * 2 5 5
     * 3 4 5
     * 4 2 2
     * 4 5 5
     * 6 4 5
     */

    static int n,m;
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;

    static void solution(int v){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Edge(v, 0));
        dis[v]=0;
        while (!priorityQueue.isEmpty()) {
            Edge poll = priorityQueue.poll();
            int vertex = poll.vertex;
            int nowCost = poll.cost;
            
            if (dis[vertex]<nowCost) continue;

            for (Edge edge : graph.get(vertex)) {
                if (dis[edge.vertex] > edge.cost + nowCost) {
                    dis[edge.vertex]= edge.cost+nowCost;
                    priorityQueue.offer(new Edge(edge.vertex, edge.cost+nowCost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        m= Integer.parseInt(st.nextToken());

        dis = new int[n+1];
        // 배열을 가장 큰 값으로 채움
        Arrays.fill(dis, Integer.MAX_VALUE);

        graph = new ArrayList<>();

        // List에 값 저장
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
        }

        solution(1);

        for (int i = 2; i <= n; i++) {
            if (dis[i]==Integer.MAX_VALUE) bw.write(i + " : impossible\n");
            else bw.write(i + " : " + dis[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}

class Edge implements Comparable<Edge> {
    int vertex;
    int cost;

    public Edge(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}