package greedy.원더랜드;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Edge2> graph;
    
    public static int find(int[] nodes, int a) {

        if (nodes[a]!=a) nodes[a] = find(nodes, nodes[a]);

        return nodes[a];
    }

    public static void union(int[] nodes, int a, int b) {
        a=find(nodes, a);
        b=find(nodes, b);
        if (a>b) nodes[a]=b;
        else nodes[b]=a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v= Integer.parseInt(st.nextToken());
        int e= Integer.parseInt(st.nextToken());

        int[] nodes = new int[v+1];

        for (int i = 1; i <= v; i++)
            nodes[i]=i;

        graph = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());

            graph.add(new Edge2(a,b,c));
        }

        Collections.sort(graph);

        int answer=0;
        for (Edge2 edge : graph) {
            int a = edge.getNodeA();
            int b = edge.getNodeB();
            int cost = edge.getCost();
            if (find(nodes, a) != find(nodes, b)) {
                union(nodes, a, b);
                answer+=cost;
            }
        }

        System.out.println(answer);
    }
}

class Edge2 implements Comparable<Edge2>{
    private final int nodeA;
    private final int nodeB;
    private final int cost;

    public Edge2(int nodeA, int nodeB, int cost) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
        this.cost = cost;
    }

    public int getNodeA() {
        return nodeA;
    }

    public int getNodeB() {
        return nodeB;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public int compareTo(Edge2 o) {
        return this.cost-o.cost;
    }
}