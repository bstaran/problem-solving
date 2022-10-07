package greedy.원더랜드_프림;

import greedy.다익스트라알고리즘.Edge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static boolean[] check;
    static ArrayList<ArrayList<Edge>> graph;
    static PriorityQueue<Edge> pQ;

    public static int solution() {

        int answer=0;

        pQ.offer(new Edge(1, 0));
        while (!pQ.isEmpty()) {

            Edge e = pQ.poll();

            if (!check[e.getVertex()]) {
                check[e.getVertex()] = true;
                answer += e.getCost();

                for (Edge edge : graph.get(e.getVertex())) {
                    if (!check[edge.getVertex()]) pQ.offer(edge);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        check = new boolean[v + 1];
        pQ = new PriorityQueue<>();

        for (int i = 0; i <= v; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        System.out.println(solution());
    }
}

